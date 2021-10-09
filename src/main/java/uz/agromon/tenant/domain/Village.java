package uz.agromon.tenant.domain;


import java.util.List;

public class Village {
    Integer sequence;
    Integer tenantId;
    Integer districtSequence;
    String name;
    List<VillageName> names;

    public Village() {
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

    public Integer getDistrictSequence() {
        return districtSequence;
    }

    public void setDistrictSequence(Integer districtSequence) {
        this.districtSequence = districtSequence;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<VillageName> getNames() {
        return names;
    }

    public void setNames(List<VillageName> names) {
        this.names = names;
    }
}
