package uz.agromon.metrics.store.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.agromon.metrics.store.jpo.CropJpo;

public interface CropRepository extends JpaRepository<CropJpo, Integer> {
}
