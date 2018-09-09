package emmert.frank.controllers;

import emmert.frank.TicketServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TicketController {

    @Autowired
    TicketServiceImpl ticketService;

    @RequestMapping(value = "/ticket/numSeatsAvailable", method = RequestMethod.GET)
    public int numSeatsAvailable() {
        return ticketService.numSeatsAvailable();
    }
}
