import java.io.FileNotFoundException;
import java.io.IOException;

public interface Command {
    public void execute() throws IOException;
    public void undo() throws FileNotFoundException;
}
