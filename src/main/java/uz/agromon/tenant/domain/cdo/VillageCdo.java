package uz.agromon.tenant.domain.cdo;

import uz.agromon.ext.JsonSerializable;

public class VillageCdo implements JsonSerializable {
    private Integer districtSequence;
    private String name;

    public VillageCdo(Integer districtSequence, String name) {
        this.districtSequence = districtSequence;
        this.name = name;
    }

    public VillageCdo() {
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
}
