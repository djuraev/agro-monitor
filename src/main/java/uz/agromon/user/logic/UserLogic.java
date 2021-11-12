package uz.agromon.user.logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.agromon.config.exception.klass.AlreadyExistsException;
import uz.agromon.config.exception.klass.InvalidParameterException;
import uz.agromon.config.exception.klass.ResourceNotFoundException;
import uz.agromon.user.domain.User;
import uz.agromon.user.service.UserService;
import uz.agromon.user.store.UserStore;
import uz.agromon.user.store.repo.RoleRepository;
import uz.agromon.util.PasswordUtil;

import java.util.List;

@Service
public class UserLogic implements UserService {

    @Autowired
    UserStore userStore;

    @Autowired
    RoleRepository repository;

    @Override
    public User create(User user) throws AlreadyExistsException{
        if (userStore.existsByInsurance(user.getInsuranceNumber())) {
            throw new AlreadyExistsException("Insurance number already registered");
        }
        return userStore.create(user);
    }

    @Override
    public User retrieve(Integer sequence) {
        return userStore.retrieve(sequence);
    }

    @Override
    public User update(User user) {
        return userStore.update(user);
    }

    @Override
    public User login(String insuranceNumber, String password) {
        User user = userStore.retrieve(insuranceNumber);
        if (user == null) {
            throw new ResourceNotFoundException(User.class, "User with insurance number not found.");
        }
        if (!PasswordUtil.isValidPassword(password, user.getPassword())) {
            throw new InvalidParameterException("Invalid password");
        }
        return user;
    }

    @Override
    public List<User> getAllUsers() {
        return userStore.retrieve();
    }

    @Override
    public boolean userExists(String username) {
        return userStore.existsByInsurance(username);
    }
}
