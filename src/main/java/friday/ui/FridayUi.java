package friday.ui;

import friday.tasklist.FridayTaskList;
import friday.tasks.Task;

import java.util.ArrayList;

/**
 * Represents the UI of friday
 */

public class FridayUi {

    public FridayUi() { }

    /**
     * Shows the user the welcome message
     */
    public void showWelcome() {
        System.out.println("Hello! I'm friday.ui.Friday"); //Message sent when the bot is activated
        System.out.println("What can I do for you?");
    }

    public void showGoodbye() {
        System.out.println("Bye. Hope to see you again soon!");
    }

    public void showList(FridayTaskList taskList) {
        System.out.println("Here are the tasks in your list:");
        taskList.printList();
    }

    public void showTaskHasBeenDeleted(Task task, FridayTaskList tasklist) {
        System.out.println("Noted. I've removed this task:");
        System.out.println(task.taskAsString());
        System.out.println("Now you have " + tasklist.getNumberOfTasks() + " tasks in the list.");
    }
    public void showTaskHasBeenAdded(Task task, FridayTaskList tasklist) {
        System.out.println("Got it. I've added this task:"); // to notify the user that task is added
        System.out.println(task.taskAsString());
        System.out.println("Now you have " + tasklist.getNumberOfTasks() + " tasks in the list.");
    }

    public void showListHasBeenMarked(Task task) {
        System.out.println("Nice! I've marked this task as done:");
        System.out.println(task.getStatusIcon() + " " + task.getDescription());
    }

    public void showListHasBeenUnmarked(Task task) {
        System.out.println("Nice! I've unmarked this task as done:");
        System.out.println(task.getStatusIcon() + " " + task.getDescription());
    }

    public void showMatchingResults(ArrayList<String> matchingResults) {
        System.out.println("Here are the matching tasks in your list:");
        for (String task : matchingResults) {
            System.out.println(task);
        }
    }

}
