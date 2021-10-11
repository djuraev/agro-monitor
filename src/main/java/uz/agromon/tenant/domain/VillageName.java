package uz.agromon.tenant.domain;

public class VillageName {
    //
    private String langCode;
    private String localName;

    public VillageName(String langCode, String localName) {
        this.langCode = langCode;
        this.localName = localName;
    }

    public VillageName() {
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
