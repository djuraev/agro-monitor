package uz.agromon.user.store.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.agromon.user.store.jpo.RoleJpo;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<RoleJpo, Integer> {
    Optional<RoleJpo> findByName(String name);
}
