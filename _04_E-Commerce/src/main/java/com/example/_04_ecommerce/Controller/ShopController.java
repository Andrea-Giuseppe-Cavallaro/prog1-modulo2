package com.example._04_ecommerce.Controller;

import com.example._04_ecommerce.Entity.User;
import com.example._04_ecommerce.Service.CommerceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/shop")
public class ShopController {

    private final CommerceService service;

    public ShopController(CommerceService service) {
        this.service = service;
    }

    // 1️⃣ Endpoint per registrare un nuovo utente
    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody User user) {
        service.addUser(user);
        return ResponseEntity.ok("Utente registrato: " + user.getUsername());
    }

    // 2️⃣ Endpoint accessibile solo agli admin
    @PostMapping("/product")
    public ResponseEntity<String> addProduct(@RequestBody User requestUser) {
        if (!service.exists(requestUser)) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Errore: utente non trovato!");
        }
        if (!service.isAdmin(requestUser)) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Accesso negato: solo admin!");
        }
        return ResponseEntity.ok("Prodotto aggiunto con successo!");
    }

    // 3️⃣ Endpoint accessibile a tutti gli utenti registrati
    @PostMapping("/visualizza")
    public ResponseEntity<String> viewProducts(@RequestBody User requestUser) {
        if (!service.exists(requestUser)) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Errore: utente non trovato!");
        }
        return ResponseEntity.ok("Ecco i prodotti disponibili!");
    }
}