package friday.commands;

import friday.storage.FridayStorage;
import friday.tasklist.FridayTaskList;
import friday.tasks.Task;
import friday.exceptions.UnknownCommandFridayException;
import friday.ui.FridayUi;

public class FridayDeleteTaskCommand extends FridayCommand {
    public String argument;

    public FridayDeleteTaskCommand(String argument) {
        this.argument = argument;
    }

    public int process(String arg) throws UnknownCommandFridayException {
        if(arg.trim().isEmpty() || arg.trim().matches(".*\\D.*")) {
            throw new UnknownCommandFridayException("You must specify the task number to delete.");
        }

        return Integer.parseInt(arg);
    }
    @Override
    public void execute(FridayTaskList taskList, FridayUi ui, FridayStorage storage)
            throws UnknownCommandFridayException {
        int taskNo = process(this.argument);
        if(taskNo > taskList.getNumberOfTasks() + 1) {
            throw new UnknownCommandFridayException(
                    "Sorry, this task does not exist. Try the command \"list\" and delete an existing task on your list.");
        }
        Task tempTask = taskList.getTask(taskNo);
        taskList.deleteTask(taskNo);
        ui.showTaskHasBeenDeleted(tempTask,taskList);
        FridayStorage.writeListToFile(taskList.getList());
    }
}
