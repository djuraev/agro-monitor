package uz.agromon.claim.store.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.agromon.claim.store.jpo.InsuranceAgencyJpo;

public interface InsuranceAgencyRepository extends JpaRepository<InsuranceAgencyJpo, Integer> {
}
