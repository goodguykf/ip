package friday;

import friday.ui.FridayUi;

public class FridayEventCommand extends FridayCommand {
    public String argument;

    public FridayEventCommand(String argument) {
        this.argument = argument;
    }

    public String process(String arg) throws UnknownCommandFridayException {
        if(arg.trim().isEmpty()) {
            throw new UnknownCommandFridayException("Description of an Event friday.Task cannot be empty!");
        }
        return arg;
    }

    public void execute(FridayTaskList taskList, FridayUi ui, FridayStorage storage)
            throws UnknownCommandFridayException {
        String processedArgument = process(this.argument);

        String[] parts = processedArgument.split(" /from ", 2);

        if (parts.length < 2 || parts[1].trim().isEmpty()) {
            throw new UnknownCommandFridayException("Start time of a Event friday.Task cannot be empty!");
        }
        String description = parts[0];

        String[] timeParts = parts[1].split(" /to ", 2);

        //catch if there is no end time
        if (timeParts.length < 2 || timeParts[1].trim().isEmpty()) {
            throw new UnknownCommandFridayException("End time of a Event friday.Task cannot be empty!");
        }

        String from = timeParts[0];     // from

        String to = timeParts[1];       // to

        taskList.addEventTask(description, from, to);
        FridayStorage.writeListToFile(taskList.getList());
        ui.showTaskHasBeenAdded(taskList.getTask(taskList.getNumberOfTasks()),taskList);
    }
}
