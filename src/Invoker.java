import java.io.FileNotFoundException;
import java.io.IOException;

public class Invoker {
    Command[] actions;

    public Invoker(){
        actions = new Command[3];
    }

    public void setCommand(int index, Command command){
        actions[index] = command;
    }

    public void Invoke(int index) throws IOException {
        actions[index].execute();
    }

    public void Undo(int index) throws FileNotFoundException {
        actions[index].undo();
    }

}
