package uz.agromon.claim.store;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import uz.agromon.claim.domain.Claim;
import uz.agromon.claim.store.jpo.ClaimJpo;
import uz.agromon.claim.store.repo.ClaimRepository;
import uz.agromon.config.exception.klass.ResourceNotFoundException;

import java.util.Collections;
import java.util.List;

@Repository
public class ClaimStoreLogic implements ClaimStore {

    @Autowired
    ClaimRepository claimRepository;

    @Override
    public Claim create(Claim claim) {
        ClaimJpo jpo = new ClaimJpo(claim);
        return claimRepository.save(jpo).toDomain();
    }

    @Override
    public List<Claim> getByUsername(String username) {
        List<ClaimJpo> jpos = claimRepository.getAllByUsername(username);
        if (jpos == null || jpos.isEmpty()) {
            return Collections.emptyList();
        }
        return ClaimJpo.toDomain(jpos);
    }
}
