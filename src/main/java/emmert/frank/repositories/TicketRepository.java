package emmert.frank.repositories;

import emmert.frank.entities.Student;
import emmert.frank.entities.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static emmert.frank.Status.Free;
import static emmert.frank.Status.Held;

@Repository
public class TicketRepository {

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
        final Integer integer = jdbcTemplate.queryForObject("select count(*) from ticket", Integer.class);
        if (integer != null) return integer;
        else return 0;
    }

    public List<Ticket> findSeats(int numSeats) {
        return jdbcTemplate.queryForList("select * from ticket where status = ? and rownum = 5 order by seat_rank", new Object[]{Free}, Ticket.class);
    }

    public void holdSeats(List<Ticket> tickets, String email, int hold_id) {
        for (Ticket ticket : tickets) {
            jdbcTemplate.update("update ticket set status = ?, hold_id = ?, email = ? where seat_number = ?", Held, hold_id, email, ticket.getSeatNumber());
        }
    }

    public List<Ticket> findByHeldId(int id) {
        return jdbcTemplate.queryForList("select * from ticket where held_id = ?", new Object[]{id}, Ticket.class);
    }
}
