package uz.agromon.mobile.dto.response;

public class DemoResponse extends Response {
    //
    String demoVideoUrl;

    public DemoResponse(String demoVideoUrl) {
        //
        super();
        setResult(true);
        this.demoVideoUrl = demoVideoUrl;
    }

    public String getDemoVideoUrl() {
        return demoVideoUrl;
    }

    public void setDemoVideoUrl(String demoVideoUrl) {
        this.demoVideoUrl = demoVideoUrl;
    }

    public boolean getResult() {
        return super.getResult();
    }

    public String getMessage() {
        return super.getMessage();
    }

    public String getError_code() {
        return super.getError_code();
    }
}
