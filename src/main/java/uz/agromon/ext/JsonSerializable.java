package uz.agromon.ext;

import uz.agromon.util.JsonUtil;

public interface JsonSerializable {
    default String toJson() {
        return JsonUtil.toJson(this);
    }

    default String toPrettyJson() {
        return JsonUtil.toPrettyJson(this);
    }
}
