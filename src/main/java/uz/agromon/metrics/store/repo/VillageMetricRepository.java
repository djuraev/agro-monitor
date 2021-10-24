package uz.agromon.metrics.store.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.agromon.metrics.store.jpo.VillageMetricJpo;

import java.util.List;

public interface VillageMetricRepository extends JpaRepository<VillageMetricJpo, Integer> {
    List<VillageMetricJpo> getAllBy();
}
