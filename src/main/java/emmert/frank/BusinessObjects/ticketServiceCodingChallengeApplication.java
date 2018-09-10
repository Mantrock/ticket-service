package emmert.frank.BusinessObjects;

import emmert.frank.repositories.TicketRepository;
import org.apache.logging.log4j.LogManager;

import org.apache.logging.log4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ticketServiceCodingChallengeApplication {

    private static final Logger LOGGER = LogManager.getLogger(ticketServiceCodingChallengeApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(ticketServiceCodingChallengeApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(TicketRepository repository) {
        return (args) -> {
            LOGGER.info("Hello World!");
        };
    }

}