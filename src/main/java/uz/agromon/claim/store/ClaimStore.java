package uz.agromon.claim.store;

import uz.agromon.claim.domain.Claim;

public interface ClaimStore {
    Claim create(Claim claim);
    Claim getByUserSequence(Integer sequence);
}
