package uz.agromon.user.store;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import uz.agromon.config.exception.klass.ResourceNotFoundException;
import uz.agromon.user.domain.Admin;
import uz.agromon.user.store.jpo.AdminJpo;
import uz.agromon.user.store.repo.AdminRepository;

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
}
