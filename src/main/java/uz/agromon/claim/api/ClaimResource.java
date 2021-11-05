package uz.agromon.claim.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.agromon.claim.domain.Claim;
import uz.agromon.claim.service.ClaimService;
import uz.agromon.helper.APIResponse;
import uz.agromon.helper.ResponseBuilder;

@RestController
@RequestMapping("/api/claim")
public class ClaimResource {
    @Autowired
    ClaimService claimService;

    @PostMapping("/claim")
    ResponseEntity<APIResponse> createClaim(@RequestBody Claim claim) {
        Claim savedClaim = claimService.createClaim(claim);
        return ResponseBuilder.buildOk(savedClaim);
    }

    @GetMapping("/claim/{userSequence}")
    ResponseEntity<APIResponse> getUserClaim(@PathVariable String userSequence) {
        Claim claim = claimService.getClaimByUser(userSequence);
        return ResponseBuilder.buildOk(claim);
    }
}
