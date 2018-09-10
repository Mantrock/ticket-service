package emmert.frank.entities;

import java.util.List;

public class SeatHold {

    List<Ticket> ticketList;
    int seatHoldId;

    public SeatHold(){
        super();
    }

    public SeatHold(List<Ticket> ticketList, int seatHoldId) {
        this.ticketList = ticketList;
        this.seatHoldId = seatHoldId;
    }

    public List<Ticket> getTicketList() {
        return ticketList;
    }

    public void setTicketList(List<Ticket> ticketList) {
        this.ticketList = ticketList;
    }

    public int getSeatHoldId() {
        return seatHoldId;
    }

    public void setSeatHoldId(int seatHoldId) {
        this.seatHoldId = seatHoldId;
    }

    @Override
    public String toString() {
        return "SeatHold{" +
                "ticketList=" + ticketList +
                ", seatHoldId=" + seatHoldId +
                '}';
    }
}
