package michal.jakbiak;

import michal.jakbiak.Commands.FailureHandle;
import michal.jakbiak.Commands.HelpHandle;
import michal.jakbiak.Commands.LineHandle;
import michal.jakbiak.Commands.MachineHandle;
import michal.jakbiak.input.UserInputCommand;
import michal.jakbiak.input.UserInputManager;

import java.util.ArrayList;
import java.util.List;

public class cmms {

    public static void main(String[] args) {
        new cmms().start();
    }

    private void start() {

        //Uruchomienie aplikacji
        System.out.println("CMMS APPLICATION v0.00");
        System.out.println("Czas trwania awarii w tym tygodniu to: 50 minut");
        System.out.println("MTBF to:  480 minut");

       //Główna pętla programu
        boolean applicationLoop = true;
        UserInputManager userInputMenager = new UserInputManager();

        //Lista komend obsługiwanych w programie -> każda komenda tworzy obiekt do obsługi
        List<String> command = new ArrayList<>();
        command.add("line");    LineHandle lineHandle = new LineHandle();
        command.add("failure"); FailureHandle failureHandle = new FailureHandle();
        command.add("machine"); MachineHandle machineHandle = new MachineHandle();
        command.add("help");     HelpHandle helpHandle = new HelpHandle();
        command.add("exit");

        while (applicationLoop) {
            try {
                UserInputCommand userInputCommand = userInputMenager.nextCommand();

                switch (userInputCommand.getCommand()) {
                    case "line":
                        lineHandle.handle(userInputCommand);
                        break;
                    case "failure":
                        failureHandle.handle(userInputCommand);
                        break;
                    case "machine":
                        machineHandle.handle(userInputCommand);
                        break;
                    case "help":
                        helpHandle.handle(userInputCommand);
                        break;
                    case "exit":
                        System.out.println("Wyjście...");
                        applicationLoop = false;
                        break;

                }

            } catch (Exception e) {
                e.printStackTrace();
            }


        }

    }

}
