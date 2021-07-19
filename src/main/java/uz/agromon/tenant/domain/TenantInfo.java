package uz.agromon.tenant.domain;

public class TenantInfo {
    Integer tenantId;
    String capital;
    String land;
    Integer userCount;
    Integer fieldCount;
    Integer villageCount;


    public TenantInfo() {
    }

    public Integer getTenantId() {
        return tenantId;
    }

    public void setTenantId(Integer tenantId) {
        this.tenantId = tenantId;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public String getLand() {
        return land;
    }

    public void setLand(String land) {
        this.land = land;
    }

    public Integer getUserCount() {
        return userCount;
    }

    public void setUserCount(Integer userCount) {
        this.userCount = userCount;
    }

    public Integer getFieldCount() {
        return fieldCount;
    }

    public void setFieldCount(Integer fieldCount) {
        this.fieldCount = fieldCount;
    }

    public Integer getVillageCount() {
        return villageCount;
    }

    public void setVillageCount(Integer villageCount) {
        this.villageCount = villageCount;
    }
}
