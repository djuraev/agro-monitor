package uz.agromon.tenant.store.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.agromon.tenant.store.jpo.RegionNameJpo;

public interface RegionNameRepository extends JpaRepository<RegionNameJpo, Integer> {
}
