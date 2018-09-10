package emmert.frank;

import emmert.frank.entities.SeatHold;
import emmert.frank.entities.Ticket;
import emmert.frank.repositories.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

@Component
public class TicketServiceImpl implements TicketService{

    private final AtomicInteger counter = new AtomicInteger();

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

        return new SeatHold(tickets, holdId);
    }

    @Override
    public String reserveSeats(int seatHoldId, String customerEmail) {
        return null;
    }
}
