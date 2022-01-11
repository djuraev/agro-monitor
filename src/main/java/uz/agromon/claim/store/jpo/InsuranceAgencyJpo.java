package uz.agromon.claim.store.jpo;

import org.springframework.beans.BeanUtils;
import uz.agromon.claim.domain.InsuranceAgency;
import uz.agromon.tenant.store.jpo.AgroMonEntity;

import javax.persistence.*;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name="INSURANCE_AGENCY")
public class InsuranceAgencyJpo extends AgroMonEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer sequence;
    private Integer tenantId;
    private String name;
    private String otherInfo;

    public InsuranceAgencyJpo() {
        //
    }

    public InsuranceAgencyJpo(InsuranceAgency domain) {
        BeanUtils.copyProperties(domain, this);
    }

    public InsuranceAgency toDomain() {
        InsuranceAgency domain = new InsuranceAgency();
        BeanUtils.copyProperties(this, domain);
        return domain;
    }

    List<InsuranceAgency> toDomains(List<InsuranceAgencyJpo> jpos) {
        return jpos.stream().map(InsuranceAgencyJpo::toDomain).collect(Collectors.toList());
    }

    public Integer getSequence() {
        return sequence;
    }

    public void setSequence(Integer sequence) {
        this.sequence = sequence;
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
