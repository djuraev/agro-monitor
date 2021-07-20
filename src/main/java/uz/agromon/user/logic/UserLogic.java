package uz.agromon.user.logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.agromon.user.domain.User;
import uz.agromon.user.service.UserService;
import uz.agromon.user.store.UserStore;

@Service
public class UserLogic implements UserService {
    @Autowired
    UserStore userStore;

    @Override
    public User create(User user) {
        return userStore.create(user);
    }

    @Override
    public User retrieve(Integer sequence) {
        return userStore.retrieve(sequence);
    }
}
