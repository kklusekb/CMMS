package michal.jakbiak.input;

import java.util.ArrayList;
import java.util.List;

public class UserInputCommand {
    public String getCommand() {
        return command;
    }

    private String command;

    public String getAction() {
        return action;
    }

    private String action;

    public List<String> getParam() {
        return param;
    }

    private List<String> param;

    public UserInputCommand(String s) {
        if (s != null) {
            String[] array = s.split("\\s");
            if (array.length > 0)
                command = array[0];
            if (array.length > 1)
                action = array[1];

            param = new ArrayList<>();
            for (int i = 2; i < array.length; i++) {
                param.add(array[i]);
            }
        }


    }

    public String toString() {
        return "UserInputCommand{" +
                "command='" + command + '\'' +
                ", action='" + action + '\'' +
                ", param=" + param +
                '}';

    }
}