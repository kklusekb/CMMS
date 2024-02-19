package michal.jakbiak.Commands;

import michal.jakbiak.DAO.LineDao;
import michal.jakbiak.DAO.MachineDao;
import michal.jakbiak.Line;
import michal.jakbiak.Machine;
import michal.jakbiak.input.UserInputCommand;

import java.util.ArrayList;
import java.util.List;

public class MachineHandle {

    //Zmienne obiektowe -> lista maszyn oraz obiektDAO
    public List<Machine> machineList;
    private MachineDao machineDao;
    private LineDao lineDao;

    //Konstruktor
    public MachineHandle() {
        machineList = new ArrayList<>();
        try {
            machineDao = new MachineDao();
            lineDao = new LineDao();
        } catch (Exception e) {
            e.printStackTrace();
        }
         machineList = machineDao.load();

    }

    //Główna metoda obsługująca komendy
    public void handle(UserInputCommand userInputCommand) {

        String lineName;
        Line line;
        String name;
        String serialNumber;


        switch (userInputCommand.getAction()) {
            case "add":
                lineName = userInputCommand.getParamByPrefix("-l");
                name = userInputCommand.getParamByPrefix("-n");
                serialNumber = userInputCommand.getParamByPrefix("-s");
                System.out.println("Dodanie maszyny");
                System.out.println(lineName + " " + name + " " + serialNumber);
                line = lineDao.findOne(lineName)
                        .orElseThrow(() -> new IllegalArgumentException("Linia nie znaleziona"));
                machineList.add(new Machine(line, name, serialNumber));
                break;

            case "delete":
                System.out.println("Linia skasowana");
                break;

            case "load":

                machineList = machineDao.load();
                break;

            case "save":
                machineDao.save(machineList);
                break;

            case "list":
                System.out.println("Lista maszyn:");
                machineList.forEach(System.out::println);
                break;

            default:
                System.out.println("Błędny parametr!");
        }
    }
}
