package emmert.frank.BusinessObjects;

import emmert.frank.entities.SeatHold;
import emmert.frank.entities.Ticket;
import emmert.frank.repositories.TicketRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public class TicketServiceImpl implements TicketService {

    private final AtomicInteger counter = new AtomicInteger();
    private static final Logger LOGGER = LogManager.getLogger(TicketServiceImpl.class);

    @Autowired
    TicketRepository ticketRepository;

    @Override
    public int numSeatsAvailable() {
        return ticketRepository.numSeatsAvailable();
    }

    @Transactional
    @Override
    public SeatHold findAndHoldSeats(int numSeats, String customerEmail) {

        int holdId = counter.incrementAndGet();
        List<Ticket> tickets = ticketRepository.findSeats(numSeats);

        ticketRepository.holdSeats(tickets, customerEmail, holdId);

        tickets = ticketRepository.findByHeldId(holdId);

        LOGGER.info(tickets);

        return new SeatHold(tickets, holdId);
    }

    @Transactional
    @Override
    public String reserveSeats(int seatHoldId, String customerEmail) {

        String confirmationNumber = UUID.randomUUID().toString();

        ticketRepository.confirmSeats(seatHoldId, customerEmail, confirmationNumber);

        return confirmationNumber;
    }
}
