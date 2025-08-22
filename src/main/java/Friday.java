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
                for(int i = 1; i < 100; i++) { //print out task recursively
                    if(list[i] == null) {
                        continue;
                    }
                    Task currTask = list[i];
                    System.out.println(i + "." + currTask.printTask());
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
                if(input.startsWith("todo")) {
                    String[] parts = input.split(" ", 2); // getting the description
                    String description = parts[1];

                    ToDos td = new ToDos(description);
                    list[pointer] = td;
                    System.out.println("Got it. I've added this task:"); // to notify the user that task is added
                    System.out.println(td.printTask());
                    System.out.println("Now you have " + pointer + " tasks in the list.");
                    pointer++;
                } else if (input.startsWith("deadline")) {
                    String[] parts = input.split(" ", 2); // getting the description
                    String impt = parts[1];

                    String[] imptParts = impt.split(" /by ", 2);
                    String description = imptParts[0];  //the description of the task
                    String deadline = imptParts[1]; //the deadline of the task

                    Deadlines dl = new Deadlines(description, deadline);
                    list[pointer] = dl;
                    System.out.println("Got it. I've added this task:"); // to notify the user that task is added
                    System.out.println(dl.printTask());
                    System.out.println("Now you have " + pointer + " tasks in the list.");
                    pointer++;
                } else if (input.startsWith("event")) {
                    String[] parts = input.split(" ", 2); // getting the description
                    String impt = parts[1];

                    String[] imptParts = impt.split(" /from ", 2);
                    String description = imptParts[0];  // event description

                    String[] timeParts = imptParts[1].split(" /to ", 2);
                    String from = timeParts[0];     // from
                    String to = timeParts[1];       // to

                    Events event = new Events(description, from, to);
                    list[pointer] = event;
                    System.out.println("Got it. I've added this task:"); // to notify the user that task is added
                    System.out.println(event.printTask());
                    System.out.println("Now you have " + pointer + " tasks in the list.");
                    pointer++;
                }
            }
        }

    }
}
