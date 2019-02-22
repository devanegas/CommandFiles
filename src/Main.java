import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;

public class Main {

    public static void main(String[] args) throws IOException {
        String name = "Test.txt";
        File file = new File(name);
        Invoker invoke = new Invoker();

/*        AddAlphaCommand addABC = new AddAlphaCommand(name);
        invoke.setCommand(0,addABC);
        invoke.Invoke(0);

        AddNumCommand add123 = new AddNumCommand(name);
        invoke.setCommand(1,add123);
        invoke.Invoke(1);*/

        RemoveLine remove = new RemoveLine(file, 8);
        invoke.setCommand(2,remove);
        invoke.Invoke(2);

    }
}
