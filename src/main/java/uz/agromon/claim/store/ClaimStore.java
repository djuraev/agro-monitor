package uz.agromon.claim.store;

import uz.agromon.claim.domain.Claim;

import java.util.List;

public interface ClaimStore {
    Claim create(Claim claim);
    List<Claim> getByUsername(String username);
}
