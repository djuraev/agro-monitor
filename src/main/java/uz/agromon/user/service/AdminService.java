package uz.agromon.user.service;

import uz.agromon.config.exception.klass.AlreadyExistsException;
import uz.agromon.user.domain.Admin;

import java.util.List;

public interface AdminService {
    Admin login(String username, String password);
    Admin create(Admin admin) throws AlreadyExistsException;
    void delete(String username);
    List<Admin> getAllManagers();
}
