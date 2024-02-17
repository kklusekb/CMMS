package michal.jakbiak.input;

import michal.jakbiak.Line;

public class Commend {
  public   static void lineCommend(UserInputCommand command)
    {
        System.out.println("Linie produkcyjne:");
        if(command.getAction()!=null) {
            if (command.getAction().equals("add")) {
             if (command.getParam().get(0)!=null)  new Line(command.getParam().get(0));
            }
        }
    }

    public void failureHandle(UserInputCommand userInputCommand) {

    }
}
