import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;

public class Main {

    public static void main(String[] args) throws IOException {
        String name = "Test.txt";
        File file = new File(name);

        AddAlphaCommand addABC = new AddAlphaCommand(name);
        Invoker invoke = new Invoker();
        invoke.setCommand(0,addABC);
        invoke.Invoke(0);

        AddNumCommand add123 = new AddNumCommand(name);
        invoke.setCommand(1,add123);
        invoke.Invoke(1);

/*        try(
            FileWriter fw = new FileWriter(name, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter out = new PrintWriter(bw)){

            out.println("12");

        }catch (IOException e){

        }*/


/*        PrintWriter writer = new PrintWriter(new FileWriter(file));
        writer.println("12");
        writer.close();



        String path = file.getAbsolutePath();
        Files.write(path, "Hello".getBytes(), StandardOpenOption.APPEND);

        PrintWriter writer2 = new PrintWriter(new FileWriter(file));
        writer2.println("\n34");
        writer2.close();*/
    }
}
