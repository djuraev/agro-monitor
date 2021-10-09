package uz.agromon.tenant.domain;


import java.util.List;

public class Region {
    Integer sequence;
    Integer tenantId;
    String name;
    List<RegionName> names;

    public List<RegionName> getNames() {
        return names;
    }

    public void setNames(List<RegionName> names) {
        this.names = names;
    }

    public Region() {
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
}
