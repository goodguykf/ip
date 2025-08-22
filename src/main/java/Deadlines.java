public class Deadlines extends Task {
    protected String deadline;

    public Deadlines(String description, String deadline) {
        super(description);
        this.deadline = deadline;
    }

    public String getDeadline() {
        return deadline;
    }

    @Override
    public String printTask() {
        return "[D]" + getStatusIcon() + " " + getDescription() + " (by :" + deadline +")";
    }

}
