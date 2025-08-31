package friday.ui;

import friday.commands.FridayCommand;
import friday.exceptions.FridayTaskDecodeException;
import friday.exceptions.UnknownCommandFridayException;
import friday.parser.FridayParser;
import friday.storage.FridayStorage;
import friday.tasklist.FridayTaskList;

import java.util.Scanner;


/**
 * Represents an automated chatbot
 */

public class Friday {
    private FridayStorage storage;
    private FridayUi ui;
    private FridayTaskList list;
    public static boolean isRunning = true;

    public static void stopRunning() {
        Friday.isRunning = false;
    }

    public Friday (String filePath) {
        this.ui = new FridayUi();
        storage = new FridayStorage(filePath);
        try {
            list = new FridayTaskList(storage.readFileToList());
        } catch (FridayTaskDecodeException e) {
            System.out.println(e.getMessage());
            list = new FridayTaskList();
        }
    }

    public void run() {
        ui.showWelcome();

        Scanner sc = new Scanner(System.in);
        boolean isRunning = true;

        while(isRunning) {
            try {
                String input = sc.nextLine();
                FridayCommand cmd = FridayParser.parse(input);
                cmd.execute(list, ui, storage);
            } catch (UnknownCommandFridayException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        new Friday("data/tasks.txt").run();
    }
}