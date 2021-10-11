package uz.agromon.tenant.domain;

public class DistrictName {
    private String langCode;
    private String localName;

    public DistrictName(String langCode, String localName) {
        this.langCode = langCode;
        this.localName = localName;
    }

    public DistrictName() {
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
