package uz.agromon.claim.logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.agromon.claim.domain.Claim;
import uz.agromon.claim.service.ClaimService;
import uz.agromon.claim.store.ClaimStore;
import uz.agromon.config.exception.klass.ResourceNotFoundException;
import uz.agromon.user.domain.User;
import uz.agromon.user.store.UserStore;

import java.util.List;

@Service
public class ClaimLogic implements ClaimService {
    @Autowired
    ClaimStore claimStore;
    @Autowired
    UserStore userStore;

    @Override
    public Claim createClaim(Claim claim) {
        User user = userStore.retrieve(claim.getUsername());
        if (user == null) {
            throw new ResourceNotFoundException(User.class, "User cannot be found.");
        }
        claim.setTenantId(user.getTenantId());
        return claimStore.create(claim);
    }

    @Override
    public List<Claim> getAllUserClaim(String username) {

        return claimStore.getByUsername(username);
    }

    @Override
    public List<Claim> getClaimsByStatus(String tenant, String status) {
        Integer tId = Integer.valueOf(tenant);
        return claimStore.retrieveByStatus(tId, status);
    }
}
