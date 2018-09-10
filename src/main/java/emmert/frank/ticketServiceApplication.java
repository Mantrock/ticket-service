package emmert.frank;

import emmert.frank.repositories.TicketRepository;
import org.apache.logging.log4j.LogManager;

import org.apache.logging.log4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class ticketServiceApplication {

    private static final Logger LOGGER = LogManager.getLogger(ticketServiceApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(ticketServiceApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(TicketRepository repository) throws InterruptedException {
            return (args) -> {
                LOGGER.info("Hello World!");
            };
    }

}