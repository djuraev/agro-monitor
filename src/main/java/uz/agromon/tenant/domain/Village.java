package uz.agromon.tenant.domain;


import org.springframework.beans.BeanUtils;
import uz.agromon.tenant.domain.cdo.VillageCdo;
import uz.agromon.tenant.store.jpo.VillageJpo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Village {
    Integer sequence;
    Integer tenantId;
    Integer districtSequence;
    String name;
    String coordinates;
    List<VillageName> names;

    public Village() {
        names = new ArrayList<>();
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

    public VillageJpo toJpo() {
        VillageJpo jpo = new VillageJpo();
        BeanUtils.copyProperties(this, jpo);
        return jpo;
    }

    public static List<VillageJpo> toJpos(List<Village> villages) {
        return villages.stream().map(Village::toJpo).collect(Collectors.toList());
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

    public String getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(String coordinates) {
        this.coordinates = coordinates;
    }
}
