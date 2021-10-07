package uz.agromon.tenant.store.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.agromon.tenant.domain.District;
import uz.agromon.tenant.store.jpo.DistrictJpo;

import java.util.List;

public interface DistrictRepository extends JpaRepository<DistrictJpo, Integer> {
    List<DistrictJpo> getAllByTenantIdAndRegionSequence(Integer tenantId, Integer regionId);
}
