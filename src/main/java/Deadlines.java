/**
 * This represents a task with a specific deadline. A <code>Deadline</code>
 * object corresponds to a deadline with specified deadline represented by
 * a string.
 */
public class Deadlines extends Task {
    protected String deadline;

    public Deadlines(String description, String deadline) {
        super(description);
        this.deadline = deadline;
    }

    /**
     * Returns the deadline of the deadline task.
     *
     * @return deadline of the task,
     */
    public String getDeadline() {
        return deadline;
    }

    @Override
    public String printTask() {
        return "[D]" + getStatusIcon() + " " + getDescription() + " (by :" + deadline +")";
    }

}
