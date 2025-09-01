package friday.parser;

import friday.commands.FridayTodoCommand;
import friday.commands.FridayUnknownCommand;
import friday.commands.FridayUnmarkAsDoneCommand;
import friday.commands.*;

/**
 *
 */

public class FridayParser {
    /**
     * Parses the String of command the user input and return a
     * FridayCommand object according the the user input.
     * @param fullCommand is the command input from user.
     * @return FridayCommand
     */
    public static FridayCommand parse(String fullCommand) {
        String[] parts = fullCommand.trim().split(" ", 2);
        String commandWord = parts[0];
        String args = parts.length > 1 ? parts[1].trim() : " ";

        return switch (commandWord) {
            case "list" -> new FridayGetListCommand();
            case "todo" -> new FridayTodoCommand(args);
            case "deadline" -> new FridayDeadlineCommand(args);
            case "event" -> new FridayEventCommand(args);
            case "delete" -> new FridayDeleteTaskCommand(args);
            case "mark" -> new FridayMarkAsDoneCommand(args);
            case "unmark" -> new FridayUnmarkAsDoneCommand(args);
            case "find" -> new FridayFindCommand(args);
            case "bye" -> new FridayExitCommand();
            default -> new FridayUnknownCommand();
        };
    }
}
