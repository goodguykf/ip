public class Events extends Task {
    protected String from;
    protected String to;

    public Events(String description, String from, String to) {
        super(description);
        this.from = from;
        this.to = to;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    @Override
    public String printTask() {
        return "[E]" + getStatusIcon() + " " + getDescription()
                + " (from: " + from + " to: " + to + ")";
    }

}
