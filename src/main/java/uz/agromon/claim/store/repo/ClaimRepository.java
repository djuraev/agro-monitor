package uz.agromon.claim.store.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.agromon.claim.store.jpo.ClaimJpo;

public interface ClaimRepository extends JpaRepository<ClaimJpo, Integer> {
    ClaimJpo getByUserSequence(Integer sequence);
}
