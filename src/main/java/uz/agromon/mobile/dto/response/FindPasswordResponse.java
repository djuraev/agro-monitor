package uz.agromon.mobile.dto.response;

public class FindPasswordResponse extends Response {
    //
    private String password;

    public FindPasswordResponse() {
        //
    }

    public FindPasswordResponse(String password) {
        result = true;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
