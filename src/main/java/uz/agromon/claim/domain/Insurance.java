package uz.agromon.claim.domain;


public class Insurance {
    private Integer userSequence;
    private Integer tenantSequence;
    private Integer farmSequence;
    private Integer agencySequence;
    private String insuranceNumber;
    private String insurancePeriod;

    public Insurance(Integer userSequence, Integer tenantSequence, Integer farmSequence, Integer agencySequence, String insuranceNumber, String insurancePeriod) {
        this.userSequence = userSequence;
        this.tenantSequence = tenantSequence;
        this.farmSequence = farmSequence;
        this.agencySequence = agencySequence;
        this.insuranceNumber = insuranceNumber;
        this.insurancePeriod = insurancePeriod;
    }

    public Insurance() {
        //
    }

    public Integer getUserSequence() {
        return userSequence;
    }

    public void setUserSequence(Integer userSequence) {
        this.userSequence = userSequence;
    }

    public Integer getTenantSequence() {
        return tenantSequence;
    }

    public void setTenantSequence(Integer tenantSequence) {
        this.tenantSequence = tenantSequence;
    }

    public Integer getFarmSequence() {
        return farmSequence;
    }

    public void setFarmSequence(Integer farmSequence) {
        this.farmSequence = farmSequence;
    }

    public Integer getAgencySequence() {
        return agencySequence;
    }

    public void setAgencySequence(Integer agencySequence) {
        this.agencySequence = agencySequence;
    }

    public String getInsuranceNumber() {
        return insuranceNumber;
    }

    public void setInsuranceNumber(String insuranceNumber) {
        this.insuranceNumber = insuranceNumber;
    }

    public String getInsurancePeriod() {
        return insurancePeriod;
    }

    public void setInsurancePeriod(String insurancePeriod) {
        this.insurancePeriod = insurancePeriod;
    }
}
