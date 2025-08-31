package friday;

import friday.commands.FridayCommand;
import friday.storage.FridayStorage;
import friday.ui.FridayUi;

public class FridayUnmarkAsDoneCommand extends FridayCommand {
    public String argument;

    public FridayUnmarkAsDoneCommand(String argument) {
        this.argument = argument;
    }

    public int process(String arg) throws UnknownCommandFridayException {
        if(arg.trim().isEmpty() || arg.trim().matches(".*\\D.*")) {
            throw new UnknownCommandFridayException("You must specify the task number to unmark.");
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
        if(taskNo > taskList.numberOfTasks + 1) {
            throw new UnknownCommandFridayException(
                    "Sorry, this task does not exist. Try the command \"list\" and mark an existing task on your list.");
        }
        taskList.markTaskAsUndone(taskNo);
        FridayStorage.writeListToFile(taskList.getList());
        ui.showListHasBeenUnmarked(taskList.getTask(taskNo));
    }
}
