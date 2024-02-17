package michal.jakbiak.Commands;

import michal.jakbiak.input.UserInputCommand;

public class HelpHandle {

    public void handle(UserInputCommand userInputCommand)
    {
        System.out.println("Dostępne komendy");
        System.out.println("line");
        System.out.println("machine");
        System.out.println("failure");
    }

}
