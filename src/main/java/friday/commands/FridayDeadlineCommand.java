package friday.commands;

import friday.storage.FridayStorage;
import friday.tasklist.FridayTaskList;
import friday.exceptions.UnknownCommandFridayException;
import friday.ui.FridayUi;

/**
 * Represents the deadline command that can create a deadline task
 */
public class FridayDeadlineCommand extends FridayCommand {
    public String argument;

    public FridayDeadlineCommand (String argument) {
        this.argument = argument;
    }

    /**
     * Processes the argument String to check if it is valid.
     * @param arg is the command after the keyword.
     * @return a processed command.
     * @throws UnknownCommandFridayException if the argument does not fit the command description.
     */
    public String process(String arg) throws UnknownCommandFridayException {
        if(arg.trim().isEmpty()) {
            throw new UnknownCommandFridayException("Description of a Deadline friday.tasks.Task cannot be empty!");
        }
        return arg;
    }

    /**
     * Executes the deadline command and creates a deadline task and updates the list.
     * @param taskList is the tasklist the bot is using.
     * @param ui is the ui that the bot is using.
     * @param storage is the storage the bot is using.
     * @throws UnknownCommandFridayException If the description does not fit the standard.
     */
    @Override
    public String execute(FridayTaskList taskList, FridayUi ui, FridayStorage storage)
            throws UnknownCommandFridayException {
        String input = process(this.argument);

        String[] parts = input.split(" /by ", 2);

        //catch if there is no deadline entered
        if (parts.length < 2 || parts[1].trim().isEmpty()) {
            throw new UnknownCommandFridayException("Deadline of a Deadline friday.tasks.Task cannot be empty!");
        }

        String description = parts[0];  //the description of the task
        String deadline = parts[1]; //the deadline of the task

        taskList.addDeadlineTask(description, deadline);
        FridayStorage.writeListToFile(taskList.getList());
        return ui.showTaskHasBeenAdded(taskList.getTask(taskList.getNumberOfTasks()), taskList);
    }
}
