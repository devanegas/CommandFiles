import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class AddNumCommand implements Command {
    String name;

    public AddNumCommand(String name) throws IOException {
        this.name = name;
    }

    public void execute(){
        try(
        FileWriter fw = new FileWriter(name, true);
        BufferedWriter bw = new BufferedWriter(fw);
        PrintWriter out = new PrintWriter(bw)){

            out.println("0123456789");

        }catch (IOException e) {

        }
    }
}