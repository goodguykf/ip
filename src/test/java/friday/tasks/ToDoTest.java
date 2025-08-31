package friday.tasks;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ToDoTest {

    @Test
    public void testMarkTaskAsDone() {
        ToDos task = new ToDos("read book");
        assertFalse(task.isDone(), "Task should start as not done");

        task.markTaskAsDone();
        assertTrue(task.isDone(), "Task should be marked as done");
    }

    @Test
    public void testMarkTaskAsUndone() {
        ToDos task = new ToDos("write code");
        task.markTaskAsDone(); // mark it done first
        assertTrue(task.isDone(), "Task should be done after marking it");

        task.markTaskAsUndone();
        assertFalse(task.isDone(), "Task should be undone after marking it undone");
    }

    @Test
    public void testDescription() {
        ToDos task = new ToDos("finish homework");
        assertEquals("finish homework", task.getDescription(), "Description should match");
    }
}


