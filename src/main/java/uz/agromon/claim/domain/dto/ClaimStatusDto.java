package uz.agromon.claim.domain.dto;

public class ClaimStatusDto {
    private String status;

    public ClaimStatusDto() {
    }

    public ClaimStatusDto(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
