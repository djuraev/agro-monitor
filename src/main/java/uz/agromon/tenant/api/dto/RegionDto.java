package uz.agromon.tenant.api.dto;

import uz.agromon.ext.JsonSerializable;

public class RegionDto implements JsonSerializable {
    private String regionSequence;
    private String name;
    private String currentLanguage;

    public RegionDto(String regionSequence, String name, String currentLanguage) {
        this.regionSequence = regionSequence;
        this.name = name;
        this.currentLanguage = currentLanguage;
    }

    public RegionDto() {
    }

    public String getRegionSequence() {
        return regionSequence;
    }

    public void setRegionSequence(String regionSequence) {
        this.regionSequence = regionSequence;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCurrentLanguage() {
        return currentLanguage;
    }

    public void setCurrentLanguage(String currentLanguage) {
        this.currentLanguage = currentLanguage;
    }
}
