package uz.agromon.helper;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.agromon.ext.JsonSerializable;
import uz.agromon.util.JsonUtil;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CommandResponse implements JsonSerializable {
    private List<Object> entities;
    private boolean requestFailed;
    private FailureMessage failureMessage;

    public String toString() {
        return this.toJson();
    }

    public static CommandResponse fromJson(String json) {
        return (CommandResponse) JsonUtil.fromJson(json, CommandResponse.class);
    }
}
