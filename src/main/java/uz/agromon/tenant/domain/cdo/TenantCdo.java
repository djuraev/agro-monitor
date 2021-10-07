package uz.agromon.tenant.domain.cdo;

import uz.agromon.ext.JsonSerializable;
import uz.agromon.util.JsonUtil;

public class TenantCdo implements JsonSerializable {
    String country;
    String shortName;

    public String toString() {
        //
        return toJson();
    }

    public static TenantCdo fromJson(String json) {
        //
        return JsonUtil.fromJson(json, TenantCdo.class);
    }
}
