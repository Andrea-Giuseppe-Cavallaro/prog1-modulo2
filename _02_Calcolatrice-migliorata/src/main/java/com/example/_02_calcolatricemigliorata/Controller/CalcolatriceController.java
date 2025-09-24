package com.example._02_calcolatricemigliorata.Controller;

import com.example._02_calcolatricemigliorata.Service.CalcolatriceService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CalcolatriceController {

    private final CalcolatriceService calcolatrice;

    public CalcolatriceController(CalcolatriceService calcolatrice) {
        this.calcolatrice = calcolatrice;
    }

    @GetMapping("/add/{a}/{b}")
    public @ResponseBody
    String add(@PathVariable float a, @PathVariable float b) {
        return "Somma = " + calcolatrice.add(a, b);
    }

    @GetMapping("/sub/{a}/{b}")
    public @ResponseBody
    String sub(@PathVariable float a, @PathVariable float b) {
        return "Differenza = " + calcolatrice.sub(a, b);
    }

    @GetMapping("/mul/{a}/{b}")
    public @ResponseBody
    String mul(@PathVariable float a, @PathVariable float b) {
        return "Prodotto = " + calcolatrice.mul(a, b);
    }

    @GetMapping("/div/{a}/{b}")
    public @ResponseBody
    String div(@PathVariable float a, @PathVariable float b) {
        try {
            return "Divisione = " + calcolatrice.div(a, b);
        } catch (ArithmeticException e) {
            return "Errore: " + e.getMessage();
        }
    }
}