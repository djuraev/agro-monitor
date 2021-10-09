package uz.agromon.tenant.domain;


public class RegionName {
    private String langCode;
    private String name;

    public RegionName() {

    }

    public RegionName(String langCode, String name) {
        this.langCode = langCode;
        this.name = name;
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
