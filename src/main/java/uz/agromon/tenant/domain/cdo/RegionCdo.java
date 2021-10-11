package uz.agromon.tenant.domain.cdo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.agromon.ext.JsonSerializable;
import uz.agromon.util.JsonUtil;

@Setter
@Getter
@NoArgsConstructor
public class RegionCdo implements JsonSerializable {
    private Integer tenantId;
    private String name;

    public String toString() {
        //
        return toJson();
    }

    public RegionCdo(Integer tenantId, String name) {
        this.tenantId = tenantId;
        this.name = name;
    }

    public static RegionCdo fromJson(String json) {
        //
        return JsonUtil.fromJson(json, RegionCdo.class);
    }

    public Integer getTenantId() {
        return tenantId;
    }

    public void setTenantId(Integer tenantId) {
        this.tenantId = tenantId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
