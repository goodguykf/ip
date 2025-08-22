public class ToDos extends Task {
    public ToDos(String description) {
        super(description);
    }

    @Override
    public String printTask() {
        return "[T]" + getStatusIcon() + " " + getDescription();
    }
}
