package math.calcolatrice;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller

public class CalcolatriceController {

    //localhost:8082/add/num1/num2
    @GetMapping(path = "add/{num1}/{num2}")
    public @ResponseBody
    String add(@PathVariable String num1, @PathVariable String num2) {
        //try-catch per gestire input errati
        try {
            int a = Integer.parseInt(num1);
            int b = Integer.parseInt(num2);
            return "Somma = " + (a + b);
        } catch (NumberFormatException e) {
            return "Errore: i parametri devono essere numeri interi!";
        }
    }

    //localhost:8082/sub/num1/num2
    @GetMapping(path = "sub/{num1}/{num2}")
    public @ResponseBody
    String sub(@PathVariable String num1, @PathVariable String num2) {
        //try-catch per gestire input errati
        try {
            int a = Integer.parseInt(num1);
            int b = Integer.parseInt(num2);
            return "Differenza = " + (a - b);
        }  catch (NumberFormatException e) {
            return "Errore: i parametri devono essere numeri interi";
        }
    }

    //localhost:8082/multiply/num1/num2
    @GetMapping(path = "multiply/{num1}/{num2}")
    public @ResponseBody
    String multiply(@PathVariable String num1, @PathVariable String num2) {
        //try-catch per gestire input errati
        try {
            int a = Integer.parseInt(num1);
            int b = Integer.parseInt(num2);
            return "Prodotto = " + (a * b);
        }  catch (NumberFormatException e) {
            return "Errore: i parametri devono essere numeri interi";
        }
    }

    //localhost:8082/division/num1/num2
    @GetMapping(path = "division/{num1}/{num2}")
    public @ResponseBody
    String division(@PathVariable String num1, @PathVariable String num2) {
        //try-catch per gestire input errati
        try {
            //try-catch per gestire lo 0 al denominatore
            try{
                int a = Integer.parseInt(num1);
                int b = Integer.parseInt(num2);
                return "Divisione = " + (a / b);
            }catch(ArithmeticException e){
                return "Errore, hai messo lo 0 al denominatore";
            }
        }  catch (NumberFormatException e) {
            return "Errore: i parametri devono essere numeri interi";
        }
    }
}
