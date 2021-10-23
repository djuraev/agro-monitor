package uz.agromon.user.store.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.agromon.user.store.jpo.UserJpo;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserJpo, Integer> {
    UserJpo findByEmail(String email);
    Optional<UserJpo> findByInsuranceNumber(String insuranceNumber);
    boolean existsByInsuranceNumber(String insuranceNumber);
}
