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
    public String showWelcome() {
        return "Hello boss, Friday here!\nWhat can I do for you?";
    }

    public String showGoodbye() {
        return "Bye. Hope to see you again soon!";
    }

    public String showList(FridayTaskList taskList) {
        StringBuilder sb = new StringBuilder();
        sb.append("Here are the tasks in your list:\n");
        sb.append(taskList.listAsString());
        return sb.toString();
    }

    public String showTaskHasBeenDeleted(Task task, FridayTaskList tasklist) {
        return "Noted. I've removed this task:\n"
                + task.taskAsString() + "\n"
                + "Now you have " + tasklist.getNumberOfTasks() + " tasks in the list.";
    }

    public String showTaskHasBeenAdded(Task task, FridayTaskList tasklist) {
        return "Got it. I've added this task:\n"
                + task.taskAsString() + "\n"
                + "Now you have " + tasklist.getNumberOfTasks() + " tasks in the list.";
    }

    public String showListHasBeenMarked(Task task) {
        return "Nice! I've marked this task as isDone:\n"
                + task.getStatusIcon() + " " + task.getDescription();
    }

    public String showListHasBeenUnmarked(Task task) {
        return "Nice! I've unmarked this task as isDone:\n"
                + task.getStatusIcon() + " " + task.getDescription();
    }

    public String showMatchingResults(ArrayList<String> matchingResults) {
        StringBuilder sb = new StringBuilder();
        sb.append("Here are the matching tasks in your list:\n");
        for (String task : matchingResults) {
            sb.append(task).append("\n");
        }
        return sb.toString().trim();
    }
}