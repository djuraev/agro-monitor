package uz.agromon.tenant.domain;

import com.fasterxml.jackson.annotation.JsonInclude;

public class TenantName {
    //
    private String lanCode;
    private String name;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String tenantCode;

    public TenantName(String lanCode, String name) {
        //
        this.lanCode = lanCode;
        this.name = name;
    }

    public TenantName() {
        //
    }

    public String getLanCode() {
        return lanCode;
    }

    public void setLanCode(String lanCode) {
        this.lanCode = lanCode;
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
