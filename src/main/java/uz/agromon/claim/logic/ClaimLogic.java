package uz.agromon.claim.logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.agromon.claim.domain.Claim;
import uz.agromon.claim.service.ClaimService;
import uz.agromon.claim.store.ClaimStore;

@Service
public class ClaimLogic implements ClaimService {
    @Autowired
    ClaimStore claimStore;

    @Override
    public Claim createClaim(Claim claim) {
        return claimStore.create(claim);
    }

    @Override
    public Claim getClaimByUser(String userSequence) {
        Integer id = Integer.parseInt(userSequence);
        return claimStore.getByUserSequence(id);
    }
}
