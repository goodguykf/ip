import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Represents a file reader. It contains a static method inside which posses
 * the ability to read the contents of a file.
 */


public class FridayFileReader {

    /**
     * Prints the lines inside the file one by one as it is scanned.
     * @param filePath The path of the file
     * @throws FileNotFoundException If the file does not exist.
     */
    public static void printFileContents(String filePath) throws FileNotFoundException {
        File f = new File(filePath);
        Scanner s = new Scanner(f);

        if(!s.hasNextLine()) {
            System.out.println("You have no tasks in your list.");
            s.close();
            return;
        }

        while (s.hasNext()) {
            System.out.println(s.nextLine());
        }
        s.close();
    }
}
