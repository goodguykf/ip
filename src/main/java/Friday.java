import java.util.*;

public class Friday {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int pointer = 1; //Pointer to keep track of where to store incoming task
        Task[] list = new Task[100]; //List to store tasks

        System.out.println("\nHello! I'm Friday"); //Message sent when the bot is activated
        System.out.println("What can I do for you?");


        //To keep the system running
        while (true) {
            String input = sc.nextLine();

            if(input.equals("bye")) {
                System.out.println("\n  Bye. Hope to see you again soon!"); //notify user that bot is turning off
                break;
            } else if(input.equals("list")) {
                System.out.println("Here are the tasks in your list:");
                for(int i = 1; i < pointer; i++) { //print out task recursively
                    Task currTask = list[i];
                    System.out.println(i + "." + currTask.getStatusIcon() + " " + currTask.getDescription());
                }
            } else if (input.startsWith("mark ")) {
                //this marks the task as done when it is requested
                int taskNumberForMarked = Integer.parseInt(input.split(" ")[1]); //this extracts the task number
                System.out.println("Nice! I've marked this task as done:");
                Task currTask = list[taskNumberForMarked];
                currTask.isDone = true;
                System.out.println(currTask.getStatusIcon() + " " + currTask.getDescription());

            } else if (input.startsWith("unmark ")) {
                //this unmarks the task as done when it is requested
                int taskNumberForUnmarked = Integer.parseInt(input.split(" ")[1]); //this extracts the task number
                System.out.println("Nice! I've marked this task as done:");
                Task currTask = list[taskNumberForUnmarked];
                currTask.isDone = false;
                System.out.println(currTask.getStatusIcon() + " " + currTask.getDescription());

            } else {
                Task t = new Task(input);
                list[pointer] = t;
                pointer++;
                System.out.println("added: " + input); // to notify the user that task is added
            }
        }

    }
}
