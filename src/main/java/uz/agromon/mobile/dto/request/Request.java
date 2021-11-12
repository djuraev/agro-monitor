package uz.agromon.mobile.dto.request;

public class Request {
    //
    String username;
    String language;

    public Request() {
        //
    }

    public Request(String username, String language) {
        //
        this.username = username;
        this.language = language;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}
