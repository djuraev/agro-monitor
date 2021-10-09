package uz.agromon.tenant.store.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.agromon.tenant.store.jpo.TenantNameJpo;

public interface TenantNameRepository extends JpaRepository<TenantNameJpo, Integer> {
    TenantNameJpo getByLangCode(String langCode);
}
