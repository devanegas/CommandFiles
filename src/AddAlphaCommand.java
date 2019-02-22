import java.io.*;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class AddAlphaCommand implements Command {
    File file;
    File backup;

    public AddAlphaCommand(File file){
        this.file = file;
    }

    public void setBackup() throws IOException {
        //Generate Backup
        backup = new File("temp_" +file.getName());
        Files.copy(file.toPath(), backup.toPath(), StandardCopyOption.REPLACE_EXISTING);
    }


    public void execute() throws IOException {

        if(file.exists())
            setBackup();
        try(
                FileChannel channel = new RandomAccessFile(file, "rw").getChannel();
                FileWriter fw = new FileWriter(file.getName(), true);
                BufferedWriter bw = new BufferedWriter(fw);
                PrintWriter out = new PrintWriter(bw)){

            FileLock lock;
            lock = channel.tryLock();

            if( lock != null ) {
                out.println("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
                lock.release();
            }

        }catch (IOException e) {
            undo();
        }
    }

    public void undo() throws FileNotFoundException {

        String l;
        //Erase contents from original File
        PrintWriter writer = new PrintWriter(file.getName());
        writer.print("");
        writer.close();

        //Repopulate File
        try(BufferedReader br = new BufferedReader(new FileReader("temp_" +file.getName())))
        {
            while( (l = br.readLine() ) != null) {
                try(
                        FileWriter fw = new FileWriter(file.getName(), true);
                        BufferedWriter bw = new BufferedWriter(fw);
                        PrintWriter out = new PrintWriter(bw)){

                    out.println(l);
                }
            }
        }catch (IOException e) { }

        //Delete temporary file
        //backup.delete();
    }
}
