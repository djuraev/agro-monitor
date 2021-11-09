package uz.agromon.claim.domain;


public class Insurance {
    private Integer userSequence;
    private Integer tenantSequence;
    private Integer fieldSequence;
    private Integer agencySequence;
    private String insuranceNumber;
    private String insurancePeriod;

    public Insurance(Integer userSequence, Integer tenantSequence, Integer fieldSequence, Integer agencySequence, String insuranceNumber, String insurancePeriod) {
        this.userSequence = userSequence;
        this.tenantSequence = tenantSequence;
        this.fieldSequence = fieldSequence;
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

    public Integer getFieldSequence() {
        return fieldSequence;
    }

    public void setFieldSequence(Integer fieldSequence) {
        this.fieldSequence = fieldSequence;
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
