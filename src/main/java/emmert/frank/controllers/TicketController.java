package emmert.frank.controllers;

import emmert.frank.TicketServiceImpl;
import emmert.frank.entities.SeatHold;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class TicketController {

    private static final Logger LOGGER = LogManager.getLogger(TicketController.class);

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

    @RequestMapping(value = "/ticket/reserveSeats/{numSeats}/{email}", method = RequestMethod.POST)
    public String reserveSeats(@RequestParam(value="seatHoldId") int seatHoldId, @RequestParam(value="customerEmail") String customerEmail) {
        return ticketService.reserveSeats(seatHoldId, customerEmail);
    }
}
