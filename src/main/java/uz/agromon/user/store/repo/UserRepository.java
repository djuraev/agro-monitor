package uz.agromon.user.store.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.agromon.user.store.jpo.UserJpo;

public interface UserRepository extends JpaRepository<UserJpo, Integer> {
    UserJpo findByEmail(String email);
}
