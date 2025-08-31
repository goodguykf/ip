package friday.tasks;

/**
 * Represents a possible task that can be done by the user. A <code>friday.tasks.Task</code>
 * object corresponds to a task represented by a String and the state of
 * the object, represented by a boolean, with true meaning it has been completed and false meaning it has
 * yet to be completed.
 */
public class Task {
    protected String description;
    protected boolean done;

    public Task (String description) {
        this.description = description;
        this.done = false;
    }

    /**
     * Returns the description of the task.
     *
     * @return the description of the task,
     */
    public String getDescription() {
        return description;
    }

    /**
     * Returns a String that corresponds to the representation of
     * the Status of the object.
     *
     * @return the String representation of the status of the object
     */
    public String getStatusIcon() {
        return ( done ? "[X]" : "[ ]");
    }

    /**
     * Returns a String representation of the task
     *
     * @return a String representation of the task.
     */
    public String printTask() {
        return getStatusIcon() + getDescription();
    }

    public boolean isDone() {
        return done;
    }

    public void markTaskAsDone() {
        done = true;
    }

    public void markTaskAsUndone() {
        done = false;
    }
}
