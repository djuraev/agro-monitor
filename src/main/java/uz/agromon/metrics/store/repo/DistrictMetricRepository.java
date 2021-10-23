package uz.agromon.metrics.store.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.agromon.tenant.store.jpo.DistrictJpo;

public interface DistrictMetricRepository extends JpaRepository<DistrictJpo, Integer> {
}
