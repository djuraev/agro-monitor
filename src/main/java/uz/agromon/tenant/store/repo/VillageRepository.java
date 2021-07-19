package uz.agromon.tenant.store.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.agromon.tenant.store.jpo.VillageJpo;

public interface VillageRepository extends JpaRepository<VillageJpo, Integer> {
}
