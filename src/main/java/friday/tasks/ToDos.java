package friday.tasks;

import friday.tasks.Task;


/**
 * Represents a task that needs to be done. A <code>Todos</code> object corresponds
 * to a task represented by its description.
 */
public class ToDos extends Task {

    public ToDos(String description) {
        super(description);
    }

    /**
     * Formats the task into a String ready to print.
     * @return a String of task in the correct format.
     */
    @Override
    public String printTask() {
        return "[T]" + getStatusIcon() + " " + getDescription();
    }

}
