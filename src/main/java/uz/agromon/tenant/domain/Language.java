package uz.agromon.tenant.domain;


public class Language {
    private String name;
    private String code;
    private String nativeName;

    public Language(String name, String code, String nativeName) {
        this.name = name;
        this.code = code;
        this.nativeName = nativeName;
    }

    public Language() {

    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getNativeName() {
        return nativeName;
    }

    public void setNativeName(String nativeName) {
        this.nativeName = nativeName;
    }
}
