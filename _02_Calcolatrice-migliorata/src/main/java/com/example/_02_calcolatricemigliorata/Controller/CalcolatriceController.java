package com.example._02_calcolatricemigliorata.Controller;

import com.example._02_calcolatricemigliorata.Services.CalcolatriceService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalcolatriceController {

    private final CalcolatriceService calcolatriceService;

    public CalcolatriceController(CalcolatriceService calcolatriceService) {
        this.calcolatriceService = calcolatriceService;
    }

    @GetMapping("/add/{a}/{b}")
    public String add(@PathVariable float a, @PathVariable float b) {
        return "Somma = " + calcolatriceService.add(a, b);
    }

    @GetMapping("/sub/{a}/{b}")
    public String sub(@PathVariable float a, @PathVariable float b) {
        return "Differenza = " + calcolatriceService.sub(a, b);
    }

    @GetMapping("/mul/{a}/{b}")
    public String mul(@PathVariable float a, @PathVariable float b) {
        return "Prodotto = " + calcolatriceService.mul(a, b);
    }

    @GetMapping("/div/{a}/{b}")
    public String div(@PathVariable float a, @PathVariable float b) {
        try {
            return "Divisione = " + calcolatriceService.div(a, b);
        } catch (ArithmeticException e) {
            return "Errore: " + e.getMessage();
        }
    }
}