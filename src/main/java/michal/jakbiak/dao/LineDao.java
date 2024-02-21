package michal.jakbiak.dao;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import michal.jakbiak.Line;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.Optional;

public class LineDao {
    File lineFile;
    private ObjectMapper objectMapper;

    public LineDao() throws IOException {

        objectMapper = new ObjectMapper();

        lineFile = new File("./line.txt");
        if (!lineFile.exists()) lineFile.createNewFile();
    }

    public List<Line> load() {
    //    List<Line> lineList = new ArrayList<>();
        try {
            return objectMapper.readValue(Files.readString(lineFile.toPath()), new TypeReference<>() {
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public void save(List<Line> lineList) {
        try {
            Files.writeString(lineFile.toPath(), objectMapper.writeValueAsString(lineList));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


    public Optional<Line> findOne(String lineName) {
        return load().stream()
                .filter(c -> c.getName().equals(lineName))
                .findAny();
    }
}

