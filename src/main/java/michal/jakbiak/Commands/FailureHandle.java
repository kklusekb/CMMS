package michal.jakbiak.Commands;

import michal.jakbiak.Failure;
import michal.jakbiak.input.UserInputCommand;

import java.util.ArrayList;
import java.util.List;

public class FailureHandle {
    List<Failure> failureList;

    public FailureHandle() {
        failureList = new ArrayList<>();
    }

    public void handle(UserInputCommand userInputCommand) {
        System.out.println("Obsługa awarii");
    }
}
