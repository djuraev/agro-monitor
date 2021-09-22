package uz.agromon.tenant.domain;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class District  {
    Integer sequence;
    Integer tenantId;
    Integer regionSequence;
    String name;

    public District() {
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

    public Integer getRegionSequence() {
        return regionSequence;
    }

    public void setRegionSequence(Integer regionSequence) {
        this.regionSequence = regionSequence;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
