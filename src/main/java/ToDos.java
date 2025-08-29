/**
 * Represents a task that needs to be done. A <code>Todos</code> object corresponds
 * to a task represented by its description.
 */
public class ToDos extends Task {
    public ToDos(String description) {
        super(description);
    }

    @Override
    public String printTask() {
        return "[T]" + getStatusIcon() + " " + getDescription();
    }
}
