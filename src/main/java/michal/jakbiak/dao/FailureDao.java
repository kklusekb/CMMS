package michal.jakbiak.dao;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import michal.jakbiak.Failure;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

public class FailureDao {

    private ObjectMapper objectMapper;
    private File failureFile;

    public FailureDao() throws IOException {

        failureFile = new File("./failure.txt");
        if (!failureFile.exists()) failureFile.createNewFile();

        this.objectMapper = new ObjectMapper();
    }

    public List<Failure> load() {
        try {
            return objectMapper.readValue(Files.readString(failureFile.toPath()), new TypeReference<>() {
            });
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

    }

    public void save(List<Failure> failureList) {

        try {
            Files.writeString(failureFile.toPath(), objectMapper.writeValueAsString(failureList));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}


