package hello.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller

public class helloController {

    //localhost:8082/hello
    @GetMapping(path = "/hello")
    public @ResponseBody
    String hello() {return "Hello world :P";}

    //localhost:8082/hello/nome
    @GetMapping(path = "/hello/{name}")
    public @ResponseBody
    String hello(@PathVariable String name) {return "Hello world " + name;}
}
