import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

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


        int choice = openMenu();
        doAction(file, invoke, choice);





    }

    private static void doAction(File file, Invoker invoke, int choice) throws IOException {
        int line;
        if(choice==2){
            System.out.printf("\n>Which line do you want to delete?: ");
            Scanner input = new Scanner(System.in);
            line = input.nextInt();
            RemoveLine remove = new RemoveLine(file, line);
            if(remove.validData(file, line) == false){
                return;
            }
            invoke.setCommand(choice,remove);
            invoke.Invoke(choice);
        }
        else{
            invoke.Invoke(choice);
        }
    }


    public static int openMenu() {
        boolean Done = false;
        int choice=0;
        while(!Done) {
            boolean Used = false;
            System.out.println("Welcome to the File Writer\n\n " +
                    "\t1. Add the alphabet to your file\n" +
                    "\t2. Add numbers 1 through 9 to your file\n" +
                    "\t3. Delete a row in the file\n" +
                    "\t4. Exit");
            if (Used) {
                System.out.println("\t5. Undo the latest action");
            }
            System.out.printf(">What do you want to do?: ");
            Scanner input = new Scanner(System.in);
            choice = input.nextInt();
            if (choice > 0 && choice < 6) {
                if (choice == 4)
                    System.exit(0);
                else if (choice == 5)
                    Used = true;
                else {
                    Used = false;
                    Done = true;
                }
            }
        }

        return (choice-1);
    }
}
