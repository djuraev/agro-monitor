package uz.agromon.claim.service;

import uz.agromon.claim.domain.Claim;

import java.util.List;

public interface ClaimService {
    Claim createClaim(Claim claim);
    List<Claim> getAllUserClaim(String username);
    List<Claim> getClaimsByStatus(String tenant, String status);

    Claim updateClaimStatus(String claimSequence, String status);
}
