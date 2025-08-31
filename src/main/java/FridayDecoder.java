import java.util.ArrayList;
import java.util.List;

public class FridayDecoder {
    public static List<Task> decodeTasks(List<String> encodedTasks) throws FridayTaskDecodeException {
        List<Task> tasks = new ArrayList<>();
        for (String line : encodedTasks) {
            if (line.length() < 7) {
                throw new FridayTaskDecodeException("Line too short: " + line);
            }

            char type = line.charAt(1);
            boolean isDone = (line.charAt(4) == 'X');

            try {
                switch (type) {
                    case 'T':
                        String descT = line.substring(7).trim();
                        ToDos todo = new ToDos(descT);
                        if (isDone) todo.markTaskAsDone();
                        tasks.add(todo);
                        break;
                    case 'D':
                        int byIndex = line.indexOf("(by:");
                        if (byIndex == -1) throw new FridayTaskDecodeException("Missing deadline: " + line);
                        String descD = line.substring(7, byIndex).trim();
                        String by = line.substring(byIndex + 5, line.length() - 1).trim();
                        Deadlines deadline = new Deadlines(descD, by);
                        if (isDone) deadline.markTaskAsDone();
                        tasks.add(deadline);
                        break;
                    case 'E':
                        int fromIndex = line.indexOf("(from:");
                        int toIndex = line.indexOf("to:", fromIndex);
                        if (fromIndex == -1 || toIndex == -1) throw new FridayTaskDecodeException("Malformed event: " + line);
                        String descE = line.substring(7, fromIndex).trim();
                        String from = line.substring(fromIndex + 6, toIndex).trim();
                        String to = line.substring(toIndex + 3, line.length() - 1).trim();
                        Events event = new Events(descE, from, to);
                        if (isDone) event.markTaskAsDone();
                        tasks.add(event);
                        break;
                    default:
                        throw new FridayTaskDecodeException("Unknown task type: " + type);
                }
            } catch (Exception e) {
                throw new FridayTaskDecodeException("Failed to decode line: " + line + " (" + e.getMessage() + ")");
            }
        }
        return tasks;
    }

}
