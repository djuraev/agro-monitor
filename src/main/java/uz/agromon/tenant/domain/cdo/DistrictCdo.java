package uz.agromon.tenant.domain.cdo;

import uz.agromon.ext.JsonSerializable;

public class DistrictCdo implements JsonSerializable {
    private Integer regionSequence;
    private String name;

    public DistrictCdo(Integer regionSequence, String name) {
        this.regionSequence = regionSequence;
        this.name = name;
    }

    public DistrictCdo() {
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
