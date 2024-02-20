package michal.jakbiak;

public class Machine {

    //Zmienne

    private Line line;

    private String name;

    private String serialNumber;

    // Konstruktor
    public Machine (Line line, String name, String serialNumber) {
        this.line = line;
        this.name = name;
        this.serialNumber = serialNumber;
    }
    public Machine()
    {}

// Gettery
    public Line getLine() {
        return line;
    }

    public String getName() {
        return name;
    }
    public String getSerialNumber() {
        return serialNumber;
    }

    public void setLine(Line name) {
        this.line = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    @Override
    public String toString() {
        return
                "line=" + line +
                ", name='" + name + '\'' +
                ", serialNumber='" + serialNumber + '\'';
    }

}


