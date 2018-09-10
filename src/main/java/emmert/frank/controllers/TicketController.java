package emmert.frank.controllers;

import emmert.frank.TicketServiceImpl;
import emmert.frank.entities.SeatHold;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class TicketController {

    @Autowired
    TicketServiceImpl ticketService;

    @RequestMapping(value = "/ticket/numSeatsAvailable", method = RequestMethod.GET)
    public int numSeatsAvailable() {
        return ticketService.numSeatsAvailable();
    }

    @RequestMapping(value = "/ticket/findAndHoldSeats/{numSeats}/{email}", method = RequestMethod.POST)
    public SeatHold findAndHoldSeats(@RequestParam(value="numSeats") int numSeats, @RequestParam(value="email") String email) {
        return ticketService.findAndHoldSeats(numSeats, email);
    }
}
