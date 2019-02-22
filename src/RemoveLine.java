import java.io.*;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class RemoveLine implements Command{
    String desiredLine;
    int row_counter = 0;
    int line;
    File file;


    public RemoveLine(File file, int line) throws FileNotFoundException {
        if (validData(file, line))
        {
            this.file = file;
            this.line = line;
        }
        else{
            System.out.println("> [Error] File has ["+ row_counter +"] lines. Make sure to insert a number between [1 and " + (row_counter) + "]");
        }

    }


    private boolean validData(File file, int line) throws FileNotFoundException {
        String local_string;
        try(BufferedReader br = new BufferedReader(new FileReader(file.getName()))){
            while( (local_string = br.readLine() ) != null) {row_counter++;}
        } catch (IOException e) {
            e.printStackTrace();
        }

        if(line <= row_counter && line > 0){
            return true;
        }
        else
            return false;

    }

    public void execute() throws IOException {
        File temp = new File("temp.txt");
        int lineCount = 1;

        String l;

        //Create temporary file with new data
        try(BufferedReader br = new BufferedReader(new FileReader(file.getName())))
        {
        while( (l = br.readLine() ) != null) {
            if(lineCount == line)
            {
                System.out.println("Deleted " + l);
            }
            else {
                try(
                FileWriter fw = new FileWriter(temp.getName(), true);
                BufferedWriter bw = new BufferedWriter(fw);
                PrintWriter out = new PrintWriter(bw)){

                    out.println(l);
                    System.out.println("(" + lineCount + ")\t"+ l);
                }
            }
            lineCount++;
        }

        }catch (IOException e) { }


        //Erase contents from original File
        PrintWriter writer = new PrintWriter(file.getName());
        writer.print("");
        writer.close();

        //Repopulate File
        try(BufferedReader br = new BufferedReader(new FileReader(temp.getName())))
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
        temp.delete();
    }
}
