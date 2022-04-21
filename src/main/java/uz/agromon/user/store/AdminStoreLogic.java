package uz.agromon.user.store;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Repository;
import uz.agromon.config.exception.klass.AlreadyExistsException;
import uz.agromon.config.exception.klass.ResourceNotFoundException;
import uz.agromon.user.domain.Admin;
import uz.agromon.user.store.jpo.AdminJpo;
import uz.agromon.user.store.repo.AdminRepository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public class AdminStoreLogic implements AdminStore{
    //
    @Autowired
    AdminRepository adminRepository;

    @Override
    public Admin retrieve(String username, String password) {
        AdminJpo adminJpo = adminRepository.getByUsernameAndPassword(username, password);
        if (adminJpo == null || adminJpo.getUsername().equals("")) {
            throw new ResourceNotFoundException(Admin.class, "Admin not found. Username/password error.");
        }
        return adminJpo.toDomain();
    }

    @Override
    public Admin save(Admin admin) throws AlreadyExistsException {
        AdminJpo jpo = new AdminJpo(admin);
        if (adminRepository.existsByUsername(admin.getUsername())) {
            throw new AlreadyExistsException("Admin with username already exists");
        }
        try {
            jpo = adminRepository.save(jpo);
        }
        catch (DataIntegrityViolationException e) {
            throw new AlreadyExistsException("Cannot create new admin");
        }
         return jpo.toDomain();
    }

    @Override
    @Transactional
    public void delete(String username) {
        try {
            adminRepository.deleteByUsername(username);
        }
        catch (Exception e) {
            throw new DataIntegrityViolationException("Cannot delete manager");
        }

    }

    @Override
    public List<Admin> getAll() {
        return AdminJpo.toDomains(adminRepository.findAll());
    }
}
