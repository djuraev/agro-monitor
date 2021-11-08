package uz.agromon.tenant.domain;

public class ApiInfo {
    private String apiName;
    private String apiKey;
    private boolean isExpired;

    public ApiInfo(String apiName, String apiKey, boolean isExpired) {
        //
        this.apiName = apiName;
        this.apiKey = apiKey;
        this.isExpired = isExpired;
    }

    public ApiInfo() {
        //
    }

    public String getApiName() {
        return apiName;
    }

    public void setApiName(String apiName) {
        this.apiName = apiName;
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public boolean isExpired() {
        return isExpired;
    }

    public void setExpired(boolean expired) {
        isExpired = expired;
    }
}
