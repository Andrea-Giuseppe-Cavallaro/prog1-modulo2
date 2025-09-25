package com.example._04_ecommerce.Entity;

public class User {

    private String username;
    private String password;
    private String role; // es. "admin" o "buyer"

    // Costruttore vuoto (necessario per JSON -> Oggetto con Jackson)
    public User() { }

    // Costruttore con parametri
    public User(String username, String password, String role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }

    // GETTER e SETTER
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }
}
