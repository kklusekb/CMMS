package michal.jakbiak;


import java.security.Timestamp;
import java.util.Date;

public class Failure {
    private Machine machine;
    private String description;
    private Date timestart;
    private Date timestop;

    public Failure() {
    }

    public Failure(Machine machine, String description, Date timestart, Date timestop) {
        this.machine = machine;
        this.description = description;
        this.timestart = timestart;
        this.timestop = timestop;
    }

    public Machine getMachine() {
        return machine;
    }

    public void setMachine(Machine machine) {
        this.machine = machine;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getTimestart() {
        return timestart;
    }

    public void setTimestart(Date timestart) {
        this.timestart = timestart;
    }

    public Date getTimestop() {
        return timestop;
    }

    public void setTimestop(Date timestop) {
        this.timestop = timestop;
    }

    @Override
    public String toString() {
        return "Failure{" +
                "machine=" + machine +
                ", description='" + description + '\'' +
                ", timestart=" + timestart +
                ", timestop=" + timestop +
                '}';
    }
}
