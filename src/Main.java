import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;

public class Main {

    public static void main(String[] args) throws IOException {
        String name = "Test.txt";
        File file = new File(name);
        Invoker invoke = new Invoker();

        //Set Commands
        AddAlphaCommand addABC = new AddAlphaCommand(file);
        invoke.setCommand(0,addABC);
        AddNumCommand add123 = new AddNumCommand(file);
        invoke.setCommand(1,add123);

        invoke.Invoke(0);
        invoke.Invoke(0);
        invoke.Invoke(1);
        invoke.Invoke(1);
        invoke.Invoke(0);
        invoke.Invoke(1);
        invoke.Undo(0);


/*        RemoveLine remove = new RemoveLine(file, 2);
        invoke.setCommand(2,remove);
        invoke.Invoke(2);
        invoke.Undo(0);*/





    }
}
