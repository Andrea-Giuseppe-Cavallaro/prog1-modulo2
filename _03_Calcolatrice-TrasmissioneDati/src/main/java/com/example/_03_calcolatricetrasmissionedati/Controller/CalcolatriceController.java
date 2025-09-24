package com.example._03_calcolatricetrasmissionedati.Controller;

import com.example._03_calcolatricetrasmissionedati.Service.CalcolatriceService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
public class CalcolatriceController {
    private final CalcolatriceService calcolatrice;

    public CalcolatriceController(CalcolatriceService calcolatrice) {
        this.calcolatrice = calcolatrice;
    }

    @GetMapping("/add/{a}/{b}")
    public @ResponseBody String add(@PathVariable String a, @PathVariable String b) {
        try {
            float numA = Float.parseFloat(a);
            float numB = Float.parseFloat(b);
            return "Somma = " + calcolatrice.add(numA, numB);
        } catch (NumberFormatException e) {
            return "Inserito parametro non valido";
        }
    }

    @GetMapping( "/sub")
    public @ResponseBody String sub(@RequestParam String a, @RequestParam String b) {
        try{
            float numA = Float.parseFloat(a);
            float numB = Float.parseFloat(b);
            return "Differenza = " + calcolatrice.sub(numA, numB);
        } catch (NumberFormatException e) {
            return "Inserito parametro non valido";
            }
    }

    @PostMapping("/mul")
    public @ResponseBody String mul(@RequestBody Map<String, Object> body) {
        try {
            float a = Float.parseFloat(body.get("a").toString());
            float b = Float.parseFloat(body.get("b").toString());
            return "Prodotto = " + calcolatrice.mul(a, b);
        } catch (Exception e) {
            return "Inserito parametro non valido";
        }
    }

    @PostMapping("div")
    public @ResponseBody String div(@RequestBody Map<String, Object> body) {
        try {
            float a = Float.parseFloat(body.get("a").toString());
            float b = Float.parseFloat(body.get("b").toString());
            if (b == 0) {
                return "Hai messo 0 al denominatore";
            }
            float result = calcolatrice.div(a, b);
            return "Divisione = " + result;
        } catch (Exception e) {
            return "Inserito parametro non valido";
        }
    }
}