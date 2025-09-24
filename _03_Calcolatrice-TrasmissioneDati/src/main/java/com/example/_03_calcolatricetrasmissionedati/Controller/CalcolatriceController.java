package com.example._03_calcolatricetrasmissionedati.Controller;

import com.example._03_calcolatricetrasmissionedati.Services.CalcolatriceService;
import com.example._03_calcolatricetrasmissionedati.Transfer.Division;
import com.example._03_calcolatricetrasmissionedati.Transfer.Multiply;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping( "/sub")
    public String sub(@RequestParam float a, @RequestParam float b) {
        return "Differenza = " + calcolatriceService.sub(a, b);
    }

    @PostMapping("/mul")
    public String mul(@RequestBody Multiply multiply) {
        float result = calcolatriceService.mul(multiply.getA(), multiply.getB());
        return "Prodotto = " + result;
    }

    @PostMapping("div")
    public String div(@RequestBody Division division) {
        try {
            float result = calcolatriceService.div(division.getA(), division.getB());
            return "Divisione = " + result;
            }
        catch (ArithmeticException e) {
            return "Hai messo 0 al denominatore";
        }
    }
}