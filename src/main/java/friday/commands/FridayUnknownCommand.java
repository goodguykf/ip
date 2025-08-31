package friday;

import friday.commands.FridayCommand;
import friday.storage.FridayStorage;
import friday.ui.FridayUi;

public class FridayUnknownCommand extends FridayCommand {
    public void execute(FridayTaskList taskList, FridayUi ui, FridayStorage storage)
            throws UnknownCommandFridayException {
        throw new UnknownCommandFridayException("Oops I don't know what you mean by that. " +
                "Try using the commands like \"todo\" instead!");
    }
}
