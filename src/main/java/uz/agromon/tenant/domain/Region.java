package uz.agromon.tenant.domain;


import uz.agromon.tenant.domain.cdo.RegionCdo;

import java.util.*;

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

    public RegionCdo toCdo(String langCode) {
        RegionCdo cdo = new RegionCdo(this.tenantId, this.name);

        Map<String, RegionName> langCodes = new HashMap<>();
        names.forEach(name -> langCodes.put(name.getLangCode(), name));
        if (langCodes.containsKey(langCode)) {
            cdo.setName(langCodes.get(langCode).getLocalName());
        }
        return cdo;
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
