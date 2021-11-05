package uz.agromon.claim.store;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import uz.agromon.claim.domain.Claim;
import uz.agromon.claim.store.jpo.ClaimJpo;
import uz.agromon.claim.store.repo.ClaimRepository;
import uz.agromon.config.exception.klass.ResourceNotFoundException;

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
    public Claim getByUserSequence(Integer sequence) {
        ClaimJpo jpo = claimRepository.getByUserSequence(sequence);
        if (jpo.getUserSequence() == null) {
            throw new ResourceNotFoundException(Claim.class, "Claim not found for this user");
        }
        return jpo.toDomain();
    }
}
