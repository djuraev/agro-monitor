package uz.agromon.user.domain;

public enum ERole {
    ADMIN("Admin"),
    MODERATOR("Moderator"),
    USER("User");

    private String role;

    ERole(String role) {
        this.role = role;
    }
    public String getRole() {
        return this.role;
    }
}
