package friday.commands;

import friday.tasklist.FridayTaskList;
import friday.exceptions.UnknownCommandFridayException;
import friday.storage.FridayStorage;
import friday.ui.FridayUi;

/**
 * Represents the command to show the list of tasks
 */
public class FridayGetListCommand extends FridayCommand {
    /**
     * This prints out the list of tasks that the user have.
     * @param ui the ui that friday is using
     * @param storage the storage that the ui is using
     */
    public void execute(FridayTaskList taskList, FridayUi ui, FridayStorage storage)
            throws UnknownCommandFridayException {
        if(taskList.getList().isEmpty()){
            System.out.println("There is no Tasks in the List");
        }
        ui.showList(taskList);
    }
}
