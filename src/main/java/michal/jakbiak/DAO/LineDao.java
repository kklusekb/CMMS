package michal.jakbiak.DAO;

import michal.jakbiak.Line;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class LineDao {
    File lineFile;

    public LineDao() throws IOException {
        lineFile = new File("./line.txt");
        if (!lineFile.exists()) lineFile.createNewFile();
    }

    public List<Line> load() {
        List<Line> lineList = new ArrayList<>();
        try {
            List<String> list = Files.readAllLines(lineFile.toPath());
            for (String list_ : list) {
                lineList.add(new Line(list_));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return lineList;
    }

    public void save(List<Line> lineList) {
        List<String> list = new ArrayList<>();
        for (Line lines : lineList) {
            list.add(lines.toString());
        }

        try {
            Files.writeString(lineFile.toPath(), String.join("\n", list));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


}

