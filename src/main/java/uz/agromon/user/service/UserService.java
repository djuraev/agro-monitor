package uz.agromon.user.service;

import uz.agromon.user.domain.User;

public interface UserService {
    User create(User user);
    User retrieve(Integer sequence);
    User update(User user);
}
