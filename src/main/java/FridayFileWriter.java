import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * Represents a FileWrite class that contains a static method that when given a String textToAdd
 * and String filePath as input, it will find the file and write the textToAdd String into it.
 */
public class FridayFileWriter {
    /**
     * Write taskList into the file designated by the filePath
     *
     * @param filePath String of the file path.
     * @param list     Arraylist of task to be written
     * @throws IOException If there is any potential errors.
     */
    static void writeToFile(String filePath, List<Task> list) throws IOException {
        FileWriter fw = new FileWriter(filePath);
        for (int i = 0; i < list.size(); i++) { //print out task recursively
            Task currTask = list.get(i);
            int tempCounter = i + 1; // Start from 1 instead of 0
            fw.write(tempCounter + "." + currTask.printTask() + System.lineSeparator());
        }
        fw.close();
    }
}