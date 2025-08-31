package friday;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FridayStorage {
    public static String filePath;

    public FridayStorage(String fileAddress) {
        filePath = fileAddress;
    }

    public static void writeListToFile(ArrayList<Task> list) {
        List<String> encoded = FridayEncoder.encodeTasks(list);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (String line : encoded) {
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving tasks: " + e.getMessage());
        }
    }

    public static ArrayList<Task> readFileToList() throws FridayTaskDecodeException {
        ArrayList<Task> tasks = new ArrayList<>();
        File file = new File(filePath);

        // Create file if it doesn't exist
        try {
            file.getParentFile().mkdirs(); // create folder if missing
            file.createNewFile();
        } catch (IOException e) {
            System.out.println("Error creating file: " + e.getMessage());
        }

        // Read lines
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            List<String> lines = new ArrayList<>();
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
            tasks = new ArrayList<>(FridayDecoder.decodeTasks(lines));
        } catch (IOException e) {
            System.out.println("Error reading tasks: " + e.getMessage());
        }

        return tasks;
    }

}
