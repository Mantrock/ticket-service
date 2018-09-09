package emmert.frank;

import emmert.frank.entities.SeatHold;
import emmert.frank.repositories.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class TicketServiceImpl implements TicketService{

    @Autowired
    TicketRepository ticketRepository;

    @Override
    public int numSeatsAvailable() {
        return ticketRepository.numSeatsAvailable();
    }

    @Override
    public SeatHold findAndHoldSeats(int numSeats, String customerEmail) {
        return null;
    }

    @Override
    public String reserveSeats(int seatHoldId, String customerEmail) {
        return null;
    }
}
