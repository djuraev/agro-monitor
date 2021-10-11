package uz.agromon.tenant.domain;


import lombok.Getter;
import lombok.Setter;
import uz.agromon.tenant.domain.cdo.DistrictCdo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
public class District  {
    Integer sequence;
    Integer tenantId;
    Integer regionSequence;
    String name;
    List<DistrictName> names;

    public District() {
        names = new ArrayList<>();
    }

    public District(Integer sequence, Integer tenantId, Integer regionSequence, String name, List<DistrictName> names) {
        this.sequence = sequence;
        this.tenantId = tenantId;
        this.regionSequence = regionSequence;
        this.name = name;
        this.names = names;
    }

    public District(Integer regionSequence, String name) {
        this.regionSequence = regionSequence;
        this.name = name;
    }

    public DistrictCdo toCdo(String langCode) {
        DistrictCdo districtCdo = new DistrictCdo(regionSequence, name);
        Map<String, DistrictName> map = new HashMap<>();

        names.forEach(name1 -> map.put(name1.getLangCode(), name1));

        if (map.containsKey(langCode)) {
            districtCdo.setName(map.get(langCode).getLocalName());
        }
        return districtCdo;
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

    public List<DistrictName> getNames() {
        return names;
    }

    public void setNames(List<DistrictName> names) {
        this.names = names;
    }
}
