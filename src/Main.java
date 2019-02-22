import java.io.*;
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

        while(true) {
            int choice = openMenu();
            doAction(file, invoke, choice);
        }

    }

    private static void doAction(File file, Invoker invoke, int choice) throws IOException {
        int line;
        int action = choice-1;
        switch (choice){
            case 1:{
                invoke.Invoke(action);
                break;
            }
            case 2:{
                invoke.Invoke(action);
                break;
            }
            case 3:{
                System.out.printf("\n>Which line do you want to delete? [Press 0 to Cancel]: ");
                Scanner input = new Scanner(System.in);
                line = input.nextInt();
                if(line == 0)
                    System.exit(0);

                RemoveLine remove = new RemoveLine(file, line);
                invoke.setCommand(action, remove);
                invoke.Invoke(action);

                break;
            }
            case 4:{
                invoke.Undo(0);
                break;
            }
            case 5:{
                System.exit(0);
            }

        }
    }


    public static int openMenu() {
        boolean Done = false;
        int choice=0;
        while(!Done) {
            System.out.println("\n[Welcome to the File Writer]\n>>> Press 5 to UPDATE view <<<\n\n " +
                    "\t1. Add the alphabet to your file\n" +
                    "\t2. Add numbers 1 through 9 to your file\n" +
                    "\t3. Delete a row in the file\n" +
                    "\t4. Undo the latest action\n" +
                    "\t5. Exit and Update\n");

            System.out.printf(">What do you want to do?: ");
            Scanner input = new Scanner(System.in);
            choice = input.nextInt();
            if (choice > 0 && choice < 6) {
                    Done = true;
            }
            else{
                System.out.println(" > [ Enter a valid number! ]");
            }
        }

        return (choice);
    }
}
