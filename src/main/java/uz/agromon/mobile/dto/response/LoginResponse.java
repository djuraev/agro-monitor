package uz.agromon.mobile.dto.response;


import lombok.ToString;
import uz.agromon.tenant.domain.ApiInfo;
import uz.agromon.user.domain.User;

@ToString(callSuper = true)
public class LoginResponse extends Response {
    //
    String agromon;
    User userInfo;

    public LoginResponse(String agromon, User userInfo) {
        //
        super();
        this.agromon = agromon;
        this.userInfo = userInfo;
    }

    public LoginResponse(User userInfo, ApiInfo apiInfo) {
        super();
        this.result = true;
        this.userInfo = userInfo;
        this.agromon = apiInfo.getApiKey();
    }

    public static LoginResponse build(User userInfo, ApiInfo apiInfo) {
        LoginResponse response = new LoginResponse(userInfo, apiInfo);
        response.setResult(true);
        return response;
    }

    public LoginResponse() {
        //
        super();
        setResult(true);
    }

    public String getAgromon() {
        return agromon;
    }

    public void setAgromon(String agromon) {
        this.agromon = agromon;
    }

    public User getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(User userInfo) {
        this.userInfo = userInfo;
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
