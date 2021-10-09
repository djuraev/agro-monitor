package uz.agromon.tenant.store.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.agromon.tenant.store.jpo.LanguageJpo;

import java.util.List;

public interface LanguageRepository extends JpaRepository<LanguageJpo, Integer> {
    boolean existsByName(String name);
    LanguageJpo existsByCode(String code);
    List<LanguageJpo> getAllBy();
}
