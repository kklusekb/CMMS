package michal.jakbiak;

import michal.jakbiak.Commands.FailureHandle;
import michal.jakbiak.Commands.LineHandle;
import michal.jakbiak.Commands.MachineHandle;
import michal.jakbiak.input.Commend;
import michal.jakbiak.input.UserInputCommand;
import michal.jakbiak.input.UserInputManager;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Handler;

public class cmms {

    public static void main(String[] args) {
        new cmms().start();
        
    }

    private void start() {


        System.out.println("CMMS APPLICATION v0.00");
        System.out.println("Czas trwania awarii w tym tygodniu to: 50 minut");
        System.out.println("MTBF to:  480 minut");

        /* lines list
        lines add  - lines add linesName Lineadd(name);

        quite ->quiteApplication
         */
        boolean applicationLoop = true;
        UserInputManager userInputMenager = new UserInputManager();
        List<String> command = new ArrayList<>();
        command.add("line"); LineHandle lineHandle = new LineHandle();
        command.add("failure");
        command.add("machine");
        command.add("exit");

        while (applicationLoop)
        {
            try {
                UserInputCommand userInputCommand = userInputMenager.nextCommand();
              //  System.out.println(userInputCommand);
                System.out.println("Komenda:" + userInputCommand.getCommand());
                switch (userInputCommand.getCommand())
                {
                    case "line":   lineHandle.handle(userInputCommand); break;
                    case "failure": new FailureHandle(userInputCommand); break;
                    case "machine": new MachineHandle(userInputCommand); break;
                    case "exit":
                        System.out.println("Wyjście..."); applicationLoop = false; break;
                    //case "machine": machineHandle(userInputCommand);
                }



              }
            catch (Exception e) {e.printStackTrace();
            }


        }

    }

}
