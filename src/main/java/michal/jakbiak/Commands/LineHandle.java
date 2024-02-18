package michal.jakbiak.Commands;

import michal.jakbiak.DAO.LineDao;
import michal.jakbiak.Line;
import michal.jakbiak.input.UserInputCommand;

import java.util.ArrayList;
import java.util.List;

public class LineHandle {
    //
    private LineDao lineDao;
    public List<Line> lineList;


    public LineHandle() {
        lineList = new ArrayList<>();
        try {
            lineDao = new LineDao();
        } catch (Exception e) {
            e.printStackTrace();
        }
        lineList = lineDao.load();


    }

    public void handle(UserInputCommand userInputCommand) {

        if (null != userInputCommand.getAction()) {
            switch (userInputCommand.getAction()) {
                case "add":
                    if (!userInputCommand.getParam().isEmpty()) {
                        int i = userInputCommand.getParam().size();
                        String name = "";
                        for (int a = 0; a < i; a++) {
                            name += userInputCommand.getParam().get(a) + " ";
                        }
                        this.lineList.add(new Line(name.strip()));
                        System.out.println("linia dodana");
                    } else System.out.println("Błąd: Podaj nazwę linii");
                    break;
                case "delete":
                    System.out.println("Linia skasowana");
                    break;
                case "load":
                    lineList = lineDao.load();
                    break;
                case "save":
                    lineDao.save(lineList);
                    break;
                case "list":
                    System.out.println("Lista linii:");
                    lineList.forEach(System.out::println);
                    break;
                default:
                    System.out.println("Błędny parametr!");
            }
        } else {
            System.out.println("Podaj parametry");
        }
    }
}
