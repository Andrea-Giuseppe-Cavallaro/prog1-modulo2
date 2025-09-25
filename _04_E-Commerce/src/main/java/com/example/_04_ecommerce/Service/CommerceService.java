package com.example._04_ecommerce.Service;

import com.example._04_ecommerce.Entity.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommerceService {

    // Lista utenti simulata (in memoria)
    private final List<User> users = new ArrayList<>();

    // Aggiungere un utente (verrà usato da un endpoint /register)
    public void addUser(User user) {
        users.add(user);
    }

    // Controlla se l'utente esiste (match username + password)
    public boolean exists(User user) {
        return users.stream()
                .anyMatch(u -> u.getUsername().equals(user.getUsername())
                        && u.getPassword().equals(user.getPassword()));
    }

    // Controlla se l'utente è admin
    public boolean isAdmin(User user) {
        return users.stream()
                .anyMatch(u -> u.getUsername().equals(user.getUsername())
                        && u.getPassword().equals(user.getPassword())
                        && "admin".equalsIgnoreCase(u.getRole()));
    }

    // Per debug: lista di tutti gli utenti
    public List<User> getAllUsers() {
        return users;
    }
}