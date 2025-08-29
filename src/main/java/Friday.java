import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


/**
 * Represents a automated chatbot
 */

public class Friday {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Task> list = new ArrayList<>(); //List to store tasks
        final String fileAddress = "./data/Friday.txt";
        int numberOfTasks = 0;
        System.out.println("Hello! I'm Friday"); //Message sent when the bot is activated
        System.out.println("What can I do for you?");


        //To keep the system running
        while (true) {
            try {
                String input = sc.nextLine();

                if (input.equals("bye")) {
                    System.out.println("Bye. Hope to see you again soon!"); //notify user that bot is turning off
                    break;
                } else if (input.equals("list")) {
                    //there is no tasks in the list
                    try {
                        FridayFileReader.printFileContents(fileAddress);
                    } catch (FileNotFoundException e) {
                        System.out.println(e.getMessage());
                    }

                } else if (input.startsWith("mark ")) {
                    String[] parts = input.split(" ", 2); //this extracts the task number

                    //check if the task number inout is valid
                    if (parts.length < 2 || parts[1].trim().isEmpty() || parts[1].trim().matches(".*\\D.*")) {
                        throw new UnknownCommandFridayException("You must specify the task number to delete.");
                    }

                    int taskNumberToMark = Integer.parseInt(parts[1]);

                    //catch if the user tries to delete a non-existing task
                    if(taskNumberToMark > numberOfTasks) {
                        throw new NullFridayException("Sorry, this task does not exist. " +
                                "Try the command \"list\" and mark an existing task " +
                                "on your list.");
                    }

                    Task currTask = list.get(taskNumberToMark - 1);
                    currTask.isDone = true;
                    System.out.println("Nice! I've marked this task as done:");
                    System.out.println(currTask.getStatusIcon() + " " + currTask.getDescription());

                    try {
                        FridayFileWriter.writeToFile(fileAddress, list);
                    } catch (IOException e) {
                        System.out.println(e.getMessage());
                    }
                } else if (input.startsWith("unmark ")) {
                    //this unmarks the task as done when it is requested
                    String[] parts = input.split(" ", 2); //this extracts the task number

                    //check if the task number inout is valid
                    if (parts.length < 2 || parts[1].trim().isEmpty() || parts[1].trim().matches(".*\\D.*")) {
                        throw new UnknownCommandFridayException("You must specify the task number to delete.");
                    }

                    int taskNumberToUnmark = Integer.parseInt(parts[1]);

                    //catch if the user tries to delete a non-existing task
                    if(taskNumberToUnmark > numberOfTasks) {
                        throw new NullFridayException("Sorry, this task does not exist. " +
                                "Try the command \"list\" and mark an existing task " +
                                "on your list.");
                    }
                    Task currTask = list.get(taskNumberToUnmark - 1);
                    currTask.isDone = false;
                    System.out.println("Nice! I've unmarked this task as done:");
                    System.out.println(currTask.getStatusIcon() + " " + currTask.getDescription());

                    try {
                        FridayFileWriter.writeToFile(fileAddress, list);
                    } catch (IOException e) {
                        System.out.println(e.getMessage());
                    }

                } else if(input.startsWith("delete ")) {
                    String[] parts = input.split(" ", 2); //this extracts the task number

                    //check if the task number inout is valid
                    if (parts.length < 2 || parts[1].trim().isEmpty() || parts[1].trim().matches(".*\\D.*")) {
                        throw new UnknownCommandFridayException("You must specify the task number to delete.");
                    }

                    int taskNumberToDelete = Integer.parseInt(parts[1]);

                    //catch if the user tries to delete a non-existing task
                    if(taskNumberToDelete > numberOfTasks) {
                        throw new NullFridayException("Sorry, this task does not exist. " +
                                "Try the command \"list\" and delete an existing task " +
                                "on your list.");
                    }

                    Task currTask = list.get(taskNumberToDelete - 1);
                    list.remove(taskNumberToDelete - 1);
                    numberOfTasks--;
                    System.out.println("Noted. I've removed this task:");
                    System.out.println(currTask.printTask());
                    System.out.println("Now you have " + numberOfTasks + " tasks in the list.");

                    try {
                        FridayFileWriter.writeToFile(fileAddress, list);
                    } catch (IOException e) {
                        System.out.println(e.getMessage());
                    }

                } else {
                    if (input.startsWith("todo")) {
                        String[] parts = input.split(" ", 2); // getting the description

                        //catch if the description is empty
                        if (parts.length < 2 || parts[1].trim().isEmpty()) {
                           throw new NullFridayException("Description of a Todo Task cannot be empty!");
                        }

                        String description = parts[1];

                        ToDos td = new ToDos(description);
                        list.add(td);
                        numberOfTasks++;
                        System.out.println("Got it. I've added this task:"); // to notify the user that task is added
                        System.out.println(td.printTask());
                        System.out.println("Now you have " + numberOfTasks + " tasks in the list.");

                        try {
                            FridayFileWriter.writeToFile(fileAddress, list);
                        } catch (IOException e) {
                            System.out.println(e.getMessage());
                        }

                    } else if (input.startsWith("deadline")) {
                        String[] parts = input.split(" ", 2); // getting the description

                        //catch if the description is empty
                        if (parts.length < 2 || parts[1].trim().isEmpty()) {
                            throw new NullFridayException("Description of a Deadline Task cannot be empty!");
                        }
                        String impt = parts[1];

                        String[] imptParts = impt.split(" /by ", 2);

                        //catch if there is no deadline entered
                        if (imptParts.length < 2 || imptParts[1].trim().isEmpty()) {
                            throw new NullFridayException("Deadline of a Deadline Task cannot be empty!");
                        }

                        String description = imptParts[0];  //the description of the task
                        String deadline = imptParts[1]; //the deadline of the task

                        Deadlines dl = new Deadlines(description, deadline);
                        list.add(dl);
                        numberOfTasks++;
                        System.out.println("Got it. I've added this task:"); // to notify the user that task is added
                        System.out.println(dl.printTask());
                        System.out.println("Now you have " + numberOfTasks + " tasks in the list.");

                        try {
                            FridayFileWriter.writeToFile(fileAddress, list);
                        } catch (IOException e) {
                            System.out.println(e.getMessage());
                        }

                    } else if (input.startsWith("event")) {
                        String[] parts = input.split(" ", 2); // getting the description

                        //catch if the description is empty
                        if (parts.length < 2 || parts[1].trim().isEmpty()) {
                            throw new NullFridayException("Description of a Event Task cannot be empty!");
                        }

                        String impt = parts[1];

                        String[] imptParts = impt.split(" /from ", 2);

                        //catch if there is no start time
                        if (imptParts.length < 2 || imptParts[1].trim().isEmpty()) {
                            throw new NullFridayException("Start time of a Event Task cannot be empty!");
                        }

                        String description = imptParts[0];  // event description

                        String[] timeParts = imptParts[1].split(" /to ", 2);

                        //catch if there is no end time
                        if (timeParts.length < 2 || timeParts[1].trim().isEmpty()) {
                            throw new NullFridayException("End time of a Event Task cannot be empty!");
                        }

                        String from = timeParts[0];     // from
                        String to = timeParts[1];       // to

                        Events event = new Events(description, from, to);
                        list.add(event);
                        numberOfTasks++;
                        System.out.println("Got it. I've added this task:"); // to notify the user that task is added
                        System.out.println(event.printTask());
                        System.out.println("Now you have " + numberOfTasks + " tasks in the list.");

                        try {
                            FridayFileWriter.writeToFile(fileAddress, list);
                        } catch (IOException e) {
                            System.out.println(e.getMessage());
                        }

                    } else {
                        throw new UnknownCommandFridayException("Oops I don't know what you mean by that. " +
                                "Try using the commands like \"todo\" instead!");
                    }
                }
            } catch (UnknownCommandFridayException e) {
                System.out.println(e.getMessage());
            } catch (NullFridayException e) {
                System.out.println(e.getMessage());
            }
        }

    }
}