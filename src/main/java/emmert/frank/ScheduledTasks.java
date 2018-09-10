package emmert.frank;

import java.text.SimpleDateFormat;
import java.util.Date;

import emmert.frank.repositories.TicketRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class ScheduledTasks {

    @Autowired
    TicketRepository ticketRepository;

    private static final Logger LOGGER = LogManager.getLogger(ScheduledTasks.class);

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Transactional
    @Scheduled(fixedRate = 5000)
    public void returnHeldSeats() {
        LOGGER.info("Number of Held seats returned : " + ticketRepository.clearHeldSeats());
    }
}