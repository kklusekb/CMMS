package michal.jakbiak;

import michal.jakbiak.commands.FailureHandle;
import michal.jakbiak.commands.HelpHandle;
import michal.jakbiak.commands.LineHandle;
import michal.jakbiak.commands.MachineHandle;
import michal.jakbiak.input.UserInputCommand;
import michal.jakbiak.input.UserInputManager;

import java.util.ArrayList;
import java.util.List;

public class Cmms {

    public static void main(String[] args) {
        new Cmms().start();
    }

    private void start() {

        //Uruchomienie aplikacji
        System.out.println("CMMS APPLICATION v0.00");
        System.out.println("");
        System.out.println("Dostępne komendy: line [list, add, save, load]");
        System.out.println("                : machine [list, add, save, load] ");
        System.out.println("                : failure [list, add, save, load] ");
        System.out.println("                : exit ");
        System.out.println("                : help ");

        //Główna pętla programu
        boolean applicationLoop = true;
        UserInputManager userInputMenager = new UserInputManager();

        //Lista komend obsługiwanych w programie -> każda komenda tworzy obiekt do obsługi
        List<String> command = new ArrayList<>();
        command.add("line");
        LineHandle lineHandle = new LineHandle();
        command.add("failure");
        FailureHandle failureHandle = new FailureHandle();
        command.add("machine");
        MachineHandle machineHandle = new MachineHandle();
        command.add("help");
        HelpHandle helpHandle = new HelpHandle();
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
