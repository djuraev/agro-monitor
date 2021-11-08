package uz.agromon.mobile.dto.response;

public class AboutResponse extends Response {
    //
    String strInfoText;

    public AboutResponse(String strInfoText) {
        //
        super();
        setResult(true);
        this.strInfoText = strInfoText;
    }

    public String getStrInfoText() {
        return strInfoText;
    }

    public void setStrInfoText(String strInfoText) {
        this.strInfoText = strInfoText;
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
