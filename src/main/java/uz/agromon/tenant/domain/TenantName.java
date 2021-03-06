package uz.agromon.tenant.domain;

import com.fasterxml.jackson.annotation.JsonInclude;

public class TenantName {
    //
    private String langCode;
    private String name;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String tenantCode;

    public TenantName(String langCode, String name) {
        //
        this.langCode = langCode;
        this.name = name;
    }

    public TenantName() {
        //
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

    public String getTenantCode() {
        return tenantCode;
    }

    public void setTenantCode(String tenantCode) {
        this.tenantCode = tenantCode;
    }

}
