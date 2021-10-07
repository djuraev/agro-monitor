package uz.agromon.farm.store.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.agromon.farm.store.jpo.FarmJpo;

public interface FarmRepository extends JpaRepository<FarmJpo, Integer> {
}
