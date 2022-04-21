package uz.agromon.user.store;

import uz.agromon.config.exception.klass.AlreadyExistsException;
import uz.agromon.user.domain.Admin;

import java.util.List;

public interface AdminStore {
    Admin retrieve(String username, String password);
    Admin save(Admin admin) throws AlreadyExistsException;
    void delete(String username);
    List<Admin> getAll();
}
