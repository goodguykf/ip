package app;

import friday.commands.FridayCommand;
import friday.exceptions.FridayTaskDecodeException;
import friday.exceptions.UnknownCommandFridayException;
import friday.parser.FridayParser;
import friday.storage.FridayStorage;
import friday.tasklist.FridayTaskList;
import friday.ui.FridayUi;

import java.util.Scanner;


/**
 * Represents an automated chatbot
 */

public class Friday {
    private FridayStorage storage;
    private FridayUi ui;
    private FridayTaskList list;
    private String response;
    public static boolean isRunning = true;

    public static void stopRunning() {
        isRunning = false;
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

    /**
     * Returns a String of welcome message.
     * @return a String of welcome message.
     */
    public String getWelcome() {
        return ui.showWelcome();
    }

    public String getResponse(String input) {
        FridayCommand cmd = FridayParser.parse(input);
        String response = "";
        try {
            response = cmd.execute(list, ui, storage);
        } catch (UnknownCommandFridayException e) {
            e.getMessage();
        }

        return response;
    }

}