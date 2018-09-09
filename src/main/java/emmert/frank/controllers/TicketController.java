package emmert.frank.controllers;

import org.springframework.web.bind.annotation.RequestMapping;

public class TicketController {

    @RequestMapping("/ticket")
    public String index() {
        return "Greetings from Spring Boot!";
    }
}
