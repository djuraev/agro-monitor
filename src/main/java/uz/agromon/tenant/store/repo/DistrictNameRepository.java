package uz.agromon.tenant.store.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.agromon.tenant.store.jpo.DistrictNameJpo;

public interface DistrictNameRepository extends JpaRepository<DistrictNameJpo, Integer> {
}
