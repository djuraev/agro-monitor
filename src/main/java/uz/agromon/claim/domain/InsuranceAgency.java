package uz.agromon.claim.domain;

public class InsuranceAgency {
    private Integer tenantId;
    private String name;
    private String otherInfo;

    public InsuranceAgency(Integer tenantId, String name, String otherInfo) {
        this.tenantId = tenantId;
        this.name = name;
        this.otherInfo = otherInfo;
    }

    public InsuranceAgency() {
    }

    public Integer getTenantId() {
        return tenantId;
    }

    public void setTenantId(Integer tenantId) {
        this.tenantId = tenantId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOtherInfo() {
        return otherInfo;
    }

    public void setOtherInfo(String otherInfo) {
        this.otherInfo = otherInfo;
    }
}
