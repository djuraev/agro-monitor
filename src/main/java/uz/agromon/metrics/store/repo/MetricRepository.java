package uz.agromon.metrics.store.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.agromon.metrics.store.jpo.MetricJpo;

public interface MetricRepository extends JpaRepository<MetricJpo, Integer> {
}
