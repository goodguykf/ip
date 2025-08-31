package friday.commands;

import friday.exceptions.UnknownCommandFridayException;
import friday.storage.FridayStorage;
import friday.tasklist.FridayTaskList;
import friday.ui.FridayUi;

public class FridayTodoCommand extends FridayCommand {
    public String argument;

    public FridayTodoCommand(String argument) {
        this.argument = argument;
    }

    public String process(String arg) throws UnknownCommandFridayException {
        if(arg.trim().isEmpty()) {
            throw new UnknownCommandFridayException("Description of a Todo friday.tasks.Task cannot be empty!");
        }
        return arg;
    }

    public void execute(FridayTaskList taskList, FridayUi ui, FridayStorage storage)
            throws UnknownCommandFridayException {
        String processArgument = process(this.argument);

        taskList.addTodoTask(processArgument);
        FridayStorage.writeListToFile(taskList.getList());
        ui.showTaskHasBeenAdded(taskList.getTask(taskList.getNumberOfTasks()),taskList);
    }
}
