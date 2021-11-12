package uz.agromon.claim.logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.agromon.claim.domain.Claim;
import uz.agromon.claim.service.ClaimService;
import uz.agromon.claim.store.ClaimStore;

import java.util.List;

@Service
public class ClaimLogic implements ClaimService {
    @Autowired
    ClaimStore claimStore;

    @Override
    public Claim createClaim(Claim claim) {
        return claimStore.create(claim);
    }

    @Override
    public List<Claim> getAllUserClaim(String username) {

        return claimStore.getByUsername(username);
    }
}
