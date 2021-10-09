package uz.agromon.tenant.domain;

public class DistrictName {
    private String langCode;
    private String name;

    public DistrictName(String langCode, String name) {
        this.langCode = langCode;
        this.name = name;
    }

    public DistrictName() {
    }

    public String getLangCode() {
        return langCode;
    }

    public void setLangCode(String langCode) {
        this.langCode = langCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
