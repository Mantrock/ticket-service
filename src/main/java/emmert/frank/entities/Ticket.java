package emmert.frank.entities;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

public class Ticket {

    @NotNull
    long seatNumber;
    long seatRank;
    String status;
    int holdId;
    String confirmationCode;
    String email;

    public long getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(long seatNumber) {
        this.seatNumber = seatNumber;
    }

    public long getSeatRank() {
        return seatRank;
    }

    public void setSeatRank(long seatRank) {
        this.seatRank = seatRank;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getHoldId() {
        return holdId;
    }

    public void setHoldId(int holdId) {
        this.holdId = holdId;
    }

    public String getConfirmationCode() {
        return confirmationCode;
    }

    public void setConfirmationCode(String confirmationCode) {
        this.confirmationCode = confirmationCode;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "seatNumber=" + seatNumber +
                ", seatRank=" + seatRank +
                ", status='" + status + '\'' +
                ", holdId=" + holdId +
                ", confirmationCode='" + confirmationCode + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
