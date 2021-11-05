package uz.agromon.claim.domain;

public class Claim {
    private Integer tenantId;
    private Integer userSequence;
    private Integer farmSequence;
    private String reason;
    private String otherInfo;
    private String status;

    public Claim() {
        //
    }

    public Claim(Integer tenantId, Integer userSequence, Integer farmSequence, String reason, String otherInfo, String status) {
        //
        this.tenantId = tenantId;
        this.userSequence = userSequence;
        this.farmSequence = farmSequence;
        this.reason = reason;
        this.otherInfo = otherInfo;
        this.status = status;
    }

    public Integer getTenantId() {
        return tenantId;
    }

    public void setTenantId(Integer tenantId) {
        this.tenantId = tenantId;
    }

    public Integer getUserSequence() {
        return userSequence;
    }

    public void setUserSequence(Integer userSequence) {
        this.userSequence = userSequence;
    }

    public Integer getFarmSequence() {
        return farmSequence;
    }

    public void setFarmSequence(Integer farmSequence) {
        this.farmSequence = farmSequence;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getOtherInfo() {
        return otherInfo;
    }

    public void setOtherInfo(String otherInfo) {
        this.otherInfo = otherInfo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
