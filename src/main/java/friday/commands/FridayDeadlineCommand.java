package friday;

import friday.ui.FridayUi;

public class FridayDeadlineCommand extends FridayCommand {
    public String argument;

    public FridayDeadlineCommand (String argument) {
        this.argument = argument;
    }

    public String process(String arg) throws UnknownCommandFridayException {
        if(arg.trim().isEmpty()) {
            throw new UnknownCommandFridayException("Description of a Deadline friday.Task cannot be empty!");
        }
        return arg;
    }

    @Override
    public void execute(FridayTaskList taskList, FridayUi ui, FridayStorage storage)
            throws UnknownCommandFridayException {
        String input = process(this.argument);

        String[] parts = input.split(" /by ", 2);

        //catch if there is no deadline entered
        if (parts.length < 2 || parts[1].trim().isEmpty()) {
            throw new UnknownCommandFridayException("Deadline of a Deadline friday.Task cannot be empty!");
        }

        String description = parts[0];  //the description of the task
        String deadline = parts[1]; //the deadline of the task

        taskList.addDeadlineTask(description, deadline);
        FridayStorage.writeListToFile(taskList.getList());
        ui.showTaskHasBeenAdded(taskList.getTask(taskList.getNumberOfTasks()), taskList);
    }
}
