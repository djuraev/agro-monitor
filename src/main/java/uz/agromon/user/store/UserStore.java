package uz.agromon.user.store;

import uz.agromon.user.domain.User;

import java.util.List;

public interface UserStore {
    User create(User user);
    User retrieve(Integer sequence);
    List<User> retrieve();
    User update(User user);
}
