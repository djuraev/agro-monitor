package uz.agromon.tenant.store.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.agromon.tenant.store.jpo.TenantJpo;

public interface TenantRepository extends JpaRepository<TenantJpo, Integer> {
    TenantJpo getByCountry(String country);
    boolean existsByCountry(String country);
    TenantJpo getByCode(String code);
}
