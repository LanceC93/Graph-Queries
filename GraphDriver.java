import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class GraphDriver {
    public static void main(String[] args) {
        //checks that a file was given to read from
        if(args.length == 0) {
            System.out.println("Sorry. Please include a file.");
        } else {
            //makes sure the file exists
            try {
                File input = new File(args[0]);
                Scanner console = new Scanner(input);
                GraphList g = createGraph(console);
                console = new Scanner(System.in);
                System.out.print("Starting Node Label: ");
                if(!g.searchVertex(console.next())) {
                    System.out.println("Starting Node not found.");
                    console.close();
                    return;
                }
                System.out.print("End Node Label: ");
                if(!g.searchVertex(console.next())) {
                    System.out.println("End Node not found.");
                    console.close();
                    return;
                }
                printCommands();
                String command = console.next();
                while(!command.equals("q")) {
                    switch(command) {
                        default:
                            System.out.println("Invalid Command.");
                            break;
                    }
                    System.out.print("Enter a command: ");
                    command = console.next();
                }
                console.close();
            }     
            catch (FileNotFoundException e) {
                System.out.println("File was not found.");
            }
        }
    }

    public static GraphList createGraph(Scanner console) {
        String[] s;
        s = console.nextLine().split(" ");
        GraphList g = new GraphList(s[0]);
        g.insert(s[0],s[1],s[2]);
        while(console.hasNextLine()) {
            s = console.nextLine().split(" ");
            g.insert(s[0],s[1],s[2]);
        }
        return g;
    }

    public static void printCommands() {
        System.out.println("Commands:");
        System.out.println("(q) - quit program");
        System.out.print("Enter a command: ");
    }
}