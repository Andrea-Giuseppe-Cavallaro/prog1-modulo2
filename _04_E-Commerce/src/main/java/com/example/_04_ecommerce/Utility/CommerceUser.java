package com.example._04_ecommerce.Utility;

public class CommerceUser {
    private String username;
    private String password;
    private String role;
    public CommerceUser(String username, String password, String role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }

    // getter e setter
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }
}
