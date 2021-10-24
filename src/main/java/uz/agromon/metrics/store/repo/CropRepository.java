package uz.agromon.metrics.store.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.agromon.metrics.store.jpo.CropJpo;

import java.util.List;

public interface CropRepository extends JpaRepository<CropJpo, Integer> {
    CropJpo getByName(String cropName);
    List<CropJpo> getAllBy();
}
