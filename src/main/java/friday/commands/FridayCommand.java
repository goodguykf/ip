package friday;

import friday.ui.FridayUi;

/**
 * Represents the commands to be executed
 */
public abstract class FridayCommand {
    public void process() {
        return;
    }
    public void execute(FridayTaskList taskList, FridayUi ui, FridayStorage storage)
            throws UnknownCommandFridayException {
        return;
    }
}
