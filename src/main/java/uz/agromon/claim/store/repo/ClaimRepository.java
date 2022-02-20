package uz.agromon.claim.store.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.agromon.claim.store.jpo.ClaimJpo;

import java.util.List;

public interface ClaimRepository extends JpaRepository<ClaimJpo, Integer> {
    ClaimJpo getByUsername(String username);
    List<ClaimJpo> getAllByUsername(String username);
    List<ClaimJpo> getAllByTenantIdAndStatus(Integer tenantId, String status);
}
