import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class AddAlphaCommand implements Command {
    String name;

    public AddAlphaCommand(String name) throws IOException {
        this.name = name;
    }

    public void execute(){
        try(
            FileWriter fw = new FileWriter(name, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter out = new PrintWriter(bw)){
            out.println("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
        }catch (IOException e) {

        }
    }
}
