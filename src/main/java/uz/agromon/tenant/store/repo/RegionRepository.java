package uz.agromon.tenant.store.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.agromon.tenant.store.jpo.RegionJpo;

import java.util.List;

public interface RegionRepository extends JpaRepository<RegionJpo, Integer> {
    List<RegionJpo> getAllByTenantId(Integer tenantId);

}
