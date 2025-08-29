/**
 * Represents a task with a specific starting and ending time. A <code>Events</code>
 * object corresponds to an event represented by two timing, the start and the end
 * timing by two Strings.
 */
public class Events extends Task {
    protected String from;
    protected String to;

    public Events(String description, String from, String to) {
        super(description);
        this.from = from;
        this.to = to;
    }

    /**
     * Returns a String representing the starting time of the Event.
     *
     * @return Start time of the event.
     */
    public String getFrom() {
        return from;
    }

    /**
     * Returns a String representing the ending time of the Event.
     *
     *
     * @return End time of the event.
     */
    public String getTo() {
        return to;
    }

    @Override
    public String printTask() {
        return "[E]" + getStatusIcon() + " " + getDescription()
                + " (from: " + from + " to: " + to + ")";
    }

}
