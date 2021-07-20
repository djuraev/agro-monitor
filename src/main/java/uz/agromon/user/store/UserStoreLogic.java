package uz.agromon.user.store;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import uz.agromon.user.domain.User;
import uz.agromon.user.store.jpo.UserJpo;
import uz.agromon.user.store.repo.UserRepository;

import java.util.List;

@Repository
public class UserStoreLogic implements UserStore{
    @Autowired
    UserRepository repository;

    @Override
    public User create(User user) {
        UserJpo jpo = new UserJpo(user);
        return repository.save(jpo).toDomain();
    }

    @Override
    public User retrieve(Integer sequence) {
        UserJpo jpo = repository.getById(sequence);
        return jpo.toDomain();
    }

    @Override
    public List<User> retrieve() {
        List<UserJpo> jpos = repository.findAll();
        return UserJpo.toDomains(jpos);
    }
}
