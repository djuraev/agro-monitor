package uz.agromon.tenant.domain;


import uz.agromon.tenant.domain.cdo.VillageCdo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Village {
    Integer sequence;
    Integer tenantId;
    Integer districtSequence;
    String name;
    List<VillageName> names;

    public Village() {
    }

    public VillageCdo toCdo(String langCode) {
        VillageCdo villageCdo = new VillageCdo(districtSequence, name);
        Map<String, VillageName> map = new HashMap<>();
        names.forEach(name -> map.put(name.getLangCode(), name));
        if (map.containsKey(langCode)) {
            villageCdo.setName(map.get(langCode).getLocalName());
        }
        return villageCdo;
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
