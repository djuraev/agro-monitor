package uz.agromon.metrics.store.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.agromon.metrics.store.jpo.DistrictMetricJpo;

import java.util.List;

public interface DistrictMetricRepository extends JpaRepository<DistrictMetricJpo, Integer> {
    List<DistrictMetricJpo> getAllBy();
}
