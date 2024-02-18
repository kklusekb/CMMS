package michal.jakbiak.Commands;

import michal.jakbiak.DAO.MachineDao;
import michal.jakbiak.Line;
import michal.jakbiak.Machine;
import michal.jakbiak.input.UserInputCommand;

import java.util.ArrayList;
import java.util.List;

public class MachineHandle {
    public List<Machine> machineList;
    private MachineDao machineDao;
    public MachineHandle() {
        machineList = new ArrayList<>();
        machineDao = new MachineDao();

    }

    public void handle(UserInputCommand userInputCommand) {
            String line;
            String name;
            String serialNumber;


        switch (userInputCommand.getAction()) {
            case "add":
                if(!userInputCommand.getParam().isEmpty())  // jeśli lista parametrów nie jest pusta to ->
                {
                    int paramLength = userInputCommand.getParam().size();
                    int paramLine = -1;
                    int paramName = -1;
                    int paramSerialNumber = -1;
                    for(int i = 0; i<paramLength; i++)
                    {
                        if (userInputCommand.getParam().get(i).equals("-l")) paramLine=i+1;
                        if (userInputCommand.getParam().get(i).equals("-n")) paramName=i+1;
                        if (userInputCommand.getParam().get(i).equals("-s")) paramSerialNumber=i+1;
                    }
                    if((paramLine==-1) || (paramName == -1) || (paramSerialNumber == -1))
                    {
                        System.out.println("Podałeś złe arugmenty - Nie można utoworzyć maszyny");
                        System.out.println("Prawidłowa składnia machine add -l line_name -n machine_name -s machine_serial_number");
                    }
                    else
                    {
                        line = userInputCommand.getParam().get(paramLine);
                        name = userInputCommand.getParam().get(paramName);
                        serialNumber = userInputCommand.getParam().get(paramSerialNumber);
                        machineList.add(new Machine(new Line(line),name,serialNumber));


                        System.out.println("Dodanie maszyny");
                        System.out.println(userInputCommand.getParam());

                    }


                }
                else System.out.println("Błąd: Brak parametów maszyny ");
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
