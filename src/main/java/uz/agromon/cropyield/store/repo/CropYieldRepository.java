package uz.agromon.cropyield.store.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.agromon.cropyield.store.jpo.CropYieldJpo;

import java.util.List;

public interface CropYieldRepository extends JpaRepository<CropYieldJpo, Integer> {
    List<CropYieldJpo> getAllByFieldId(Integer fieldId);
    void deleteAllByFieldId(Integer fieldId);
    boolean existsByFieldId(Integer fieldId);
}
