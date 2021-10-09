package uz.agromon.tenant.domain;


public class RegionName {
    private String langCode;
    private String localName;

    public RegionName() {

    }

    public RegionName(String langCode, String name) {
        this.langCode = langCode;
        this.localName = name;
    }

    public String getLangCode() {
        return langCode;
    }

    public void setLangCode(String langCode) {
        this.langCode = langCode;
    }

    public String getLocalName() {
        return localName;
    }

    public void setLocalName(String localName) {
        this.localName = localName;
    }
}
