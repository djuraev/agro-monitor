package uz.agromon.helper;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import uz.agromon.ext.JsonSerializable;
import uz.agromon.util.JsonUtil;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class APIResponse implements JsonSerializable {
    private List<Object> entities;
    private boolean requestFailed;
    private FailureMessage failureMessage;

    APIResponse() {
        entities = new ArrayList<>();
    }

    public String toString() {
        return this.toJson();
    }

    public static APIResponse fromJson(String json) {
        return (APIResponse) JsonUtil.fromJson(json, APIResponse.class);
    }

    public List<Object> getEntities() {
        return entities;
    }

    public void setEntities(List<Object> entities) {
        this.entities = entities;
    }

    public boolean isRequestFailed() {
        return requestFailed;
    }

    public void setRequestFailed(boolean requestFailed) {
        this.requestFailed = requestFailed;
    }

    public FailureMessage getFailureMessage() {
        return failureMessage;
    }

    public void setFailureMessage(FailureMessage failureMessage) {
        this.failureMessage = failureMessage;
    }
}
