package emmert.frank.repositories;

import emmert.frank.entities.Ticket;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


@Repository
public class TicketRepository {

    private static final Logger LOGGER = LogManager.getLogger(TicketRepository.class);

    @Autowired
    JdbcTemplate jdbcTemplate;

    class TicketRowMapper implements RowMapper<Ticket> {
        @Override
        public Ticket mapRow(ResultSet resultSet, int rowNum) throws SQLException {
            Ticket ticket = new Ticket();
            ticket.setSeatNumber(resultSet.getInt("seat_number"));
            ticket.setSeatRank(resultSet.getLong("seat_rank"));
            ticket.setStatus(resultSet.getString("status"));
            ticket.setHoldId(resultSet.getInt("hold_id"));
            ticket.setConfirmationCode(resultSet.getString("confirmation_code"));
            ticket.setEmail(resultSet.getString("email"));
            return ticket;
        }
    }

    public List<Ticket> findAll() {
        return jdbcTemplate.query("select * from ticket", new TicketRepository.TicketRowMapper());
    }

    public int numSeatsAvailable() {
        final Integer integer = jdbcTemplate.queryForObject("select count(*) from ticket where status = ?", new Object[]{"Free"}, Integer.class);
        if (integer != null) return integer;
        else return 0;
    }

    public List<Ticket> findSeats(int numSeats) {
        return jdbcTemplate.query("select * from ticket where status = ? and ROWNUM() <= ? order by seat_rank", new Object[]{"Free", numSeats}, new TicketRowMapper());
    }

    public void holdSeats(List<Ticket> tickets, String email, int hold_id) {
        for (Ticket ticket : tickets) {
            jdbcTemplate.update("update ticket set status = ?, hold_id = ?, email = ? where seat_number = ?", "Held", hold_id, email, ticket.getSeatNumber());
        }
    }

    public List<Ticket> findByHeldId(int id) {
        return jdbcTemplate.query("select * from ticket where hold_id = ?", new Object[]{id}, new TicketRowMapper());
    }

    public void confirmSeats(int hold_id, String email, String confirmationCode) {
        jdbcTemplate.update("update ticket set status = ?, confirmation_code = ? where hold_id = ? and email = ?", "Reserved", confirmationCode, hold_id, email);
    }
}
