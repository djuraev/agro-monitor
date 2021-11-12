package uz.agromon.mobile.dto.response;

import uz.agromon.claim.domain.Claim;

import java.util.ArrayList;
import java.util.List;

public class ClaimsResponse extends Response {
    //
    List<Claim> claims;

    public ClaimsResponse() {
        //
    }

    public ClaimsResponse(List<Claim> claims) {
        //
        super();
        setResult(true);
        this.claims = new ArrayList<>();
        this.claims.addAll(claims);
    }

    public List<Claim> getClaims() {
        return claims;
    }

    public void setClaims(List<Claim> claims) {
        this.claims = claims;
    }
}
