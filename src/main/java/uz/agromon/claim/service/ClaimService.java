package uz.agromon.claim.service;

import uz.agromon.claim.domain.Claim;

public interface ClaimService {
    Claim createClaim(Claim claim);
    Claim getClaimByUser(String userSequence);
}
