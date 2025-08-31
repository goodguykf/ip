package friday;

import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;



/**
 * Represents a task with a specific starting and ending time. A <code>friday.Events</code>
 * object corresponds to an event represented by two timing, the start and the end
 * timing by two Strings.
 */
public class Events extends Task {
    protected LocalDateTime from;
    protected LocalDateTime to;

    private static final DateTimeFormatter inputFormats =
                DateTimeFormatter.ofPattern("dd/MM/yyyy HHmm");

    private static final DateTimeFormatter outputFormatter =
                DateTimeFormatter.ofPattern("dd MMM yyyy HH:mm");

    public Events(String description, String from, String to) {
        super(description);
        this.from = LocalDateTime.parse(from, inputFormats);
        this.to = LocalDateTime.parse(to, inputFormats);
    }

    /**
     * Returns a String representing the starting time of the Event.
     *
     * @return Start time of the event.
     */
    public String getFrom() {
        return from.format(outputFormatter);
    }

    /**
     * Returns a String representing the ending time of the Event.
     *
     *
     * @return End time of the event.
     */
    public String getTo() {
        return to.format(outputFormatter);
    }

    @Override
    public String printTask() {
        return "[E]" + getStatusIcon() + " " + getDescription()
                + " (from: " + getFrom() + " to: " + getTo() + ")";
    }

    public void markTaskAsDone() {
        isDone = true;
    }

    public void markTaskAsUndone() {
        isDone = false;
    }

}
