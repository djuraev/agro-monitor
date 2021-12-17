package uz.agromon.user.service;

import uz.agromon.config.exception.klass.AlreadyExistsException;
import uz.agromon.user.domain.User;

import java.util.List;

public interface UserService {
    User create(User user) throws AlreadyExistsException;
    User retrieve(Integer sequence);
    User update(User user);
    User login(String username, String password);
    List<User> getAllUsers();
    boolean userExists(String username);
    User getByInsuranceNumber(String insuranceNumber);
}
