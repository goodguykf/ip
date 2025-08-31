package friday.commands;

import friday.tasklist.FridayTaskList;
import friday.exceptions.UnknownCommandFridayException;
import friday.storage.FridayStorage;
import friday.ui.Friday;
import friday.ui.FridayUi;

public class FridayExitCommand extends FridayCommand {
    public void execute(FridayTaskList taskList, FridayUi ui, FridayStorage storage)
            throws UnknownCommandFridayException {
        System.out.println("Bye. Hope to see you again soon!"); //notify user that bot is turning off
        Friday.stopRunning();
    }
}
