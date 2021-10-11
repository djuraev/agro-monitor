package uz.agromon.tenant.store.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.agromon.tenant.store.jpo.VillageJpo;

import java.util.List;

public interface VillageRepository extends JpaRepository<VillageJpo, Integer> {
    List<VillageJpo> getAllByDistrictSequence(Integer sequence);

}
