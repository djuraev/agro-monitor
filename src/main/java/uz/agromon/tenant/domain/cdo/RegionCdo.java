package uz.agromon.tenant.domain.cdo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.agromon.ext.JsonSerializable;
import uz.agromon.util.JsonUtil;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RegionCdo implements JsonSerializable {
    private Integer tenantId;
    private String name;

    public String toString() {
        //
        return toJson();
    }

    public static RegionCdo fromJson(String json) {
        //
        return JsonUtil.fromJson(json, RegionCdo.class);
    }
}
