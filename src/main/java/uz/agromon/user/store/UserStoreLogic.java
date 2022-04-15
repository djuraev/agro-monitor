package uz.agromon.user.store;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Repository;
import uz.agromon.config.exception.klass.ResourceNotFoundException;
import uz.agromon.user.domain.ERole;
import uz.agromon.user.domain.User;
import uz.agromon.user.store.jpo.RoleJpo;
import uz.agromon.user.store.jpo.UserJpo;
import uz.agromon.user.store.repo.RoleRepository;
import uz.agromon.user.store.repo.UserRepository;
import uz.agromon.util.PasswordUtil;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
public class UserStoreLogic implements UserStore{
    @Autowired
    UserRepository repository;

    @Autowired
    RoleRepository roleRepository;

    @Override
    public User create(User user) {
        Set<RoleJpo> roleJpos = new HashSet<>();
        user.setPassword(PasswordUtil.hashPassword(user.getPassword()));
        for (String role: user.getRoles()) {
            RoleJpo roleJpo = roleRepository.findByName(role)
                    .orElseThrow(() -> new ResourceNotFoundException(ERole.class, role+ " role not found"));
            roleJpos.add(roleJpo);
        }
        UserJpo jpo = new UserJpo(user, roleJpos);
        jpo = repository.save(jpo);
        return jpo.toDomain();
    }

    @Override
    public User retrieve(Integer sequence) {
        UserJpo jpo = repository.getById(sequence);
        return jpo.toDomain();
    }

    @Override
    public List<User> retrieve() {
        List<UserJpo> jpos = repository.findAll();
        return UserJpo.toDomains(jpos);
    }

    @Override
    public User update(User user) {
        UserJpo jpo = repository.findByInsuranceNumber(user.getInsuranceNumber())
                        .orElseThrow(() -> new ResourceNotFoundException(User.class, "User not found by insurance number"));

        user.setPassword(PasswordUtil.hashPassword(user.getPassword()));
        //@FIXME
        Integer sequence = jpo.getSequence();
        BeanUtils.copyProperties(user, jpo);
        jpo.setSequence(sequence);
        jpo = repository.save(jpo);
        return jpo.toDomain();
    }

    @Override
    public User retrieve(String insuranceNumber) {
        UserJpo jpo = repository.findByInsuranceNumber(insuranceNumber)
                .orElseThrow(() -> new ResourceNotFoundException(User.class, "User not found by insurance number"));
        return jpo.toDomain();
    }

    @Override
    public boolean existsByInsurance(String insuranceNumber) {
        return repository.existsByInsuranceNumber(insuranceNumber);
    }

    @Override
    public User retrieve(String birthday, String phone, Integer districtId) {
        UserJpo userJpo = repository.findByDateOfBirthAndPhoneNumberAndDistrictSequence(birthday, phone, districtId);
        if (userJpo == null) {
            return User.getEmptyInstance();
        }
        return userJpo.toDomain();
    }

    @Override
    public User retrieve(String birthday, String phone, String insuNumber, Integer districtId) {
        UserJpo userJpo = repository.findByDateOfBirthAndPhoneNumberAndInsuranceNumberAndDistrictSequence(birthday, phone, insuNumber, districtId);
        if (userJpo == null) {
            return User.getEmptyInstance();
        }
        return userJpo.toDomain();
    }

    @Override
    public Page<User> getUserDynamicQuery(Integer tId, Integer rId, Integer dId, Integer vId, Pageable page) {
        //
        Page<UserJpo> userJpos = repository.getUsers(tId, rId, dId, vId, page);
        return null;
    }

    @Override
    public Page<UserJpo> getAll(User user, Pageable page) {
        UserJpo jpo = new UserJpo(user);
        Example<UserJpo> example = Example.of(jpo);
        return repository.findAll(example, page);
    }

    @Override
    public Page<UserJpo> getAll(User user) {
        Pageable page = PageRequest.of(0, Integer.MAX_VALUE);
        return this.getAll(user, page);
    }

    @Override
    public void deleteUser(Integer userSequence) {
        Optional<UserJpo> jpo = repository.findById(userSequence);
        if (jpo.isPresent()) {
            jpo.get().setRoles(null);
            repository.delete(jpo.get());
        }
    }
}
