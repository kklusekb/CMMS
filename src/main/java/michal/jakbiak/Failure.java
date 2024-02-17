package michal.jakbiak;

import java.security.Timestamp;

public class Failure {
    private Machine machine;
    private Timestamp timestart;
    private Timestamp timestop;

    public Failure(Machine machine, Timestamp timestart, Timestamp timestop) {
        this.machine = machine;
        this.timestart = timestart;
        this.timestop = timestop;
    }
}
