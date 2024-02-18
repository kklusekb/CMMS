package michal.jakbiak;

public class Machine {

    //Zmienne

    private Line line;



    private String name;
    private String serialNumber;

// Konstruktor
    public Machine(Line line, String name, String serialNumber) {
        this.line = line;
        this.name = name;
        this.serialNumber = serialNumber;
    }

// Gettery
    public Line getLine() {
        return line;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Machine{" +
                "line=" + line +
                ", name='" + name + '\'' +
                ", serialNumber='" + serialNumber + '\'' +
                '}';
    }

}


