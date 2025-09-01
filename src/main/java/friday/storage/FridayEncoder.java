package friday.storage;

import friday.tasks.Task;
import friday.tasks.ToDos;
import friday.tasks.Deadlines;
import friday.tasks.Events;


import java.util.ArrayList;
import java.util.List;

public class FridayEncoder {
    /**
     * Encodes the tasklist into a file
     * @param tasks is a List of Tasks
     * @return returns a list of string
     */
    public static List<String> encodeTasks(List<Task> tasks) {
        List<String> encoded = new ArrayList<>();
        for (Task t : tasks) {
            if (t instanceof ToDos) {
                encoded.add(String.format("[T][%s] %s",
                        t.isDone() ? "X" : " ",
                        t.getDescription()));
            } else if (t instanceof Deadlines) {
                Deadlines d = (Deadlines) t;
                encoded.add(String.format("[D][%s] %s (by: %s)",
                        d.isDone() ? "X" : " ",
                        d.getDescription(),
                        d.getDeadline()));
            } else if (t instanceof Events) {
                Events e = (Events) t;
                encoded.add(String.format("[E][%s] %s (from: %s to: %s)",
                        e.isDone() ? "X" : " ",
                        e.getDescription(),
                        e.getFrom(),
                        e.getTo()));
            }
        }
        return encoded;
    }
}
