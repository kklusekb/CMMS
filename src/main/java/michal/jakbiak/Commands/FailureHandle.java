package michal.jakbiak.Commands;

import michal.jakbiak.DAO.FailureDao;
import michal.jakbiak.DAO.LineDao;
import michal.jakbiak.DAO.MachineDao;
import michal.jakbiak.Failure;
import michal.jakbiak.Line;
import michal.jakbiak.Machine;
import michal.jakbiak.input.UserInputCommand;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FailureHandle {
    List<Failure> failureList;
    private FailureDao failureDao;
    private MachineDao machineDao;
    private LineDao lineDao;

    public FailureHandle() {
        failureList = new ArrayList<>();

        try {
            failureDao = new FailureDao();
            machineDao = new MachineDao();
            lineDao = new LineDao();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
     //  failureList = failureDao.load();

    }

    public void handle(UserInputCommand userInputCommand) {
        System.out.println("Obsługa awarii");

        Machine machine;
        String machineName;
        String description;
        Date dateStart;
        Date dateEnd;


        switch (userInputCommand.getAction()) {
            case "add":
                machineName = userInputCommand.getParamByPrefix("-m");
                description = userInputCommand.getParamByPrefix("-d");
                dateStart = new Date(Long.valueOf(userInputCommand.getParamByPrefix("-ds")));
                dateEnd = new Date(Long.valueOf(userInputCommand.getParamByPrefix("-de")));

                System.out.println(machineName + " " + description + " " + dateStart + " " + dateEnd);
                machine = machineDao.findOne(machineName)
                        .orElseThrow(() -> new IllegalArgumentException("Maszyna nie znaleziona"));

                /*line = lineDao.findOne(lineName)
                        .orElseThrow(() -> new IllegalArgumentException("Linia nie znaleziona")); */
                failureList.add(new Failure(machine, description, dateStart, dateEnd));
                break;

            case "delete":
                System.out.println("Linia skasowana");
                break;

            case "load":
                failureList = failureDao.load();
                //
                break;

            case "save":
                failureDao.save(failureList);
                break;

            case "list":
                System.out.println("Lista awarii:");
                failureList.forEach(System.out::println);
                break;

            default:
                System.out.println("Błędny parametr!");
        }
    }
}
