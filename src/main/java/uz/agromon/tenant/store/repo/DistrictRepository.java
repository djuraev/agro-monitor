package uz.agromon.tenant.store.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.agromon.tenant.store.jpo.DistrictJpo;

public interface DistrictRepository extends JpaRepository<DistrictJpo, Integer> {
}
