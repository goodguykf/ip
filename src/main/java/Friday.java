import java.util.*;

public class Friday {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int pointer = 1; //Pointer to keep track of where to store incoming task
        String[] list = new String[100]; //List to store tasks

        System.out.println("\nHello! I'm Friday"); //Message sent when the bot is activated
        System.out.println("What can I do for you?");


        //To keep the system running
        while (true) {
            String input = sc.nextLine();

            if(input.equals("bye")) {
                System.out.println("\n  Bye. Hope to see you again soon!"); //notify user that bot is turning off
                break;
            } else if(input.equals("list")) {
                for(int i = 1; i < pointer; i++) { //print out task recursively
                    System.out.println("    " + i + ". " + list[i]);
                }
            } else {
                list[pointer] = input;
                pointer++;
                System.out.println("added: " + input); // to notify the user that task is added
            }
        }

    }
}
