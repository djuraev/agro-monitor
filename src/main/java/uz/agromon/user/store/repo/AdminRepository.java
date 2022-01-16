package uz.agromon.user.store.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.agromon.user.store.jpo.AdminJpo;

public interface AdminRepository extends JpaRepository<AdminJpo, Integer> {
    AdminJpo getByUsernameAndPassword(String username, String password);
}
