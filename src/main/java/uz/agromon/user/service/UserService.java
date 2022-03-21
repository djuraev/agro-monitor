package uz.agromon.user.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import uz.agromon.config.exception.klass.AlreadyExistsException;
import uz.agromon.user.domain.User;
import uz.agromon.user.store.jpo.UserJpo;

import java.util.List;

public interface UserService {
    User create(User user) throws AlreadyExistsException;
    User retrieve(Integer sequence);
    User update(User user);
    User login(String username, String password);
    List<User> getAllUsers();
    boolean userExists(String username);
    User getByInsuranceNumber(String insuranceNumber);
    Page<UserJpo> findAll(User user, int pageNumber, int pageSize);
    Page<UserJpo> findAll(User user);
    void removeUser(String userSequence);
}
