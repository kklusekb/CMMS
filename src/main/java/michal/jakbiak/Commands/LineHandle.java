package michal.jakbiak.Commands;

import michal.jakbiak.Line;
import michal.jakbiak.input.UserInputCommand;

import java.util.ArrayList;
import java.util.List;

public class LineHandle {
    List<Line> lineList;
    public LineHandle() {
        lineList = new ArrayList<>();

    }

    public void handle(UserInputCommand userInputCommand)
    {


        switch (userInputCommand.getAction())
        {
            case "add":
                lineList.add(new Line(userInputCommand.getParam().get(0)));
                System.out.println("linia dodana");
                break;
            case "delete":
                System.out.println("Linia skasowana");
                break;
            case "list":
                System.out.println("Lista linii:");
                lineList.forEach(System.out::println);
                break;
            default:
                System.out.println("Błędny parametr!");
        }
    }
}
