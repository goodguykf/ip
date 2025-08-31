package friday;

import friday.tasks.Deadlines;
import friday.tasks.Events;

import java.util.ArrayList;

public class FridayTaskList {
    public ArrayList<Task> list = new ArrayList<>();
    int numberOfTasks = 0;

    public FridayTaskList(ArrayList<Task> taskList) {
        this.list = taskList;
        numberOfTasks = taskList.size();
    }

    public FridayTaskList(){}

    public void markTaskAsDone(int taskNo) {
        Task currTask = list.get(taskNo - 1);
        currTask.isDone = true;
    }

    public void markTaskAsUndone(int taskNo) {
        Task currTask = list.get(taskNo - 1);
        currTask.isDone = false;
    }

    public void deleteTask(int taskNo) {
        Task currTask = list.get(taskNo - 1);
        list.remove(taskNo - 1);
        numberOfTasks--;
    }

    public void addTodoTask(String description) {
        ToDos td = new ToDos(description);
        list.add(td);
        numberOfTasks++;
    }

    public void addDeadlineTask(String description, String deadline) {
        Deadlines dl = new Deadlines(description, deadline);
        list.add(dl);
        numberOfTasks++;
    }

    public void addEventTask(String description, String from, String to) {
        Events event = new Events(description, from, to);
        list.add(event);
        numberOfTasks++;
    }

    public int getNumberOfTasks() {
        return numberOfTasks;
    }
    public ArrayList<Task> getList() {
        return list;
    }
    
    public void printList() {
        for (int i = 0; i < list.size(); i++) {
            Task currTask = list.get(i);
            System.out.println((i + 1) + "." + currTask.printTask());
        }
    }

    public Task getTask(int taskNo) {
        return list.get(taskNo - 1);
    }



}
