package friday;

import friday.commands.FridayCommand;
import friday.ui.FridayUi;

/**
 * Represent the command that mark the task as done.
 */
public class FridayMarkAsDoneCommand extends FridayCommand {
    public String argument;

    public FridayMarkAsDoneCommand(String argument) {
        this.argument = argument;
    }

    public int process(String arg) throws UnknownCommandFridayException {
        if(arg.trim().isEmpty() || arg.trim().matches(".*\\D.*")) {
            throw new UnknownCommandFridayException("You must specify the task number to mark.");
        }

        return Integer.parseInt(arg);
    }
    /**
     * This marks the requested task as done.
     * @param taskList the task list.
     * @param storage the Storage friday.ui.Friday is using.
     */
    public void execute(FridayTaskList taskList, FridayUi ui, FridayStorage storage)
            throws UnknownCommandFridayException {
            int taskNo = process(this.argument);
            taskList.markTaskAsDone(taskNo);
            storage.writeListToFile(taskList.getList());
            ui.showListHasBeenMarked(taskList.getTask(taskNo));
    }
}
