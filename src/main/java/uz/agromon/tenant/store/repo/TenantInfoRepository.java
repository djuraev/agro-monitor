package uz.agromon.tenant.store.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.agromon.tenant.store.jpo.TenantInfoJpo;

public interface TenantInfoRepository extends JpaRepository<TenantInfoJpo, Integer> {
}
