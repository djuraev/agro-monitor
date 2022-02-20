package uz.agromon.claim.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.agromon.claim.domain.Claim;
import uz.agromon.claim.service.ClaimService;
import uz.agromon.helper.APIResponse;
import uz.agromon.helper.ResponseBuilder;
import uz.agromon.mobile.dto.response.ClaimsResponse;

import java.util.List;

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

    @GetMapping(value = "/claims/{username}")
    ResponseEntity<APIResponse> getUserClaims(@PathVariable String username) {
        List<Claim> claims = claimService.getAllUserClaim(username);
        return ResponseBuilder.buildOk(claims);
    }

    @GetMapping(value = "/claims/{tenant}/{status}")
    ResponseEntity<APIResponse> getClaimsByStatus(@PathVariable String tenant, @PathVariable String status) {
        List<Claim> claims = claimService.getClaimsByStatus(tenant, status);
        return ResponseBuilder.buildOk(claims);
    }
}
