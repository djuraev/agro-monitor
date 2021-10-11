package uz.agromon.tenant.store.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.agromon.tenant.domain.VillageName;
import uz.agromon.tenant.store.jpo.VillageNameJpo;

public interface VillageNameRepository extends JpaRepository<VillageNameJpo, Integer> {
}
