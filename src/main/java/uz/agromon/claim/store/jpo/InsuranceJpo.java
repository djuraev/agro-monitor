package uz.agromon.claim.store.jpo;

import org.springframework.beans.BeanUtils;
import uz.agromon.claim.domain.Insurance;

import javax.persistence.*;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name="INSURANCE")
public class InsuranceJpo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer sequence;
    private Integer userSequence;
    private Integer tenantId;
    private Integer farmSequence;
    private Integer agencySequence;
    private Integer insuranceNumber;
    private String insurancePeriod;

    public InsuranceJpo(Integer sequence, Integer userSequence, Integer tenantId, Integer farmSequence, Integer agencySequence, Integer insuranceNumber, String insurancePeriod) {
        //
        this.sequence = sequence;
        this.userSequence = userSequence;
        this.tenantId = tenantId;
        this.farmSequence = farmSequence;
        this.agencySequence = agencySequence;
        this.insuranceNumber = insuranceNumber;
        this.insurancePeriod = insurancePeriod;
    }

    public InsuranceJpo() {
        //
    }

    public InsuranceJpo(Insurance insurance) {
        //
        BeanUtils.copyProperties(insurance, this);
    }

    public Insurance toDomain() {
        Insurance domain = new Insurance();
        BeanUtils.copyProperties(this, domain);
        return domain;
    }

    static List<Insurance> toDomains(List<InsuranceJpo> jpos) {
        return jpos.stream().map(InsuranceJpo::toDomain).collect(Collectors.toList());
    }

    public Integer getSequence() {
        return sequence;
    }

    public void setSequence(Integer sequence) {
        this.sequence = sequence;
    }

    public Integer getUserSequence() {
        return userSequence;
    }

    public void setUserSequence(Integer userSequence) {
        this.userSequence = userSequence;
    }

    public Integer getTenantId() {
        return tenantId;
    }

    public void setTenantId(Integer tenantId) {
        this.tenantId = tenantId;
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

    public Integer getInsuranceNumber() {
        return insuranceNumber;
    }

    public void setInsuranceNumber(Integer insuranceNumber) {
        this.insuranceNumber = insuranceNumber;
    }

    public String getInsurancePeriod() {
        return insurancePeriod;
    }

    public void setInsurancePeriod(String insurancePeriod) {
        this.insurancePeriod = insurancePeriod;
    }
}
