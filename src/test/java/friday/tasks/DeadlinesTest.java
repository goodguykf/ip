package friday.tasks;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DeadlinesTest {

    @Test
    public void testMarkAsDone() {
        Deadlines deadline = new Deadlines("submit report", "12/12/2025 1200");

        // Initially, the task should not be done
        assertFalse(deadline.isDone(), "Task should start as not done");

        // Mark the task as done
        deadline.markTaskAsDone();
        assertTrue(deadline.isDone(), "Task should be done after markTaskAsDone()");
    }

    @Test
    public void testMarkAsUndone() {
        Deadlines deadline = new Deadlines("submit report", "12/12/2025 1200");

        // First mark the task as done
        deadline.markTaskAsDone();
        assertTrue(deadline.isDone(), "Task should be done before marking as undone");

        // Now mark it as undone
        deadline.markTaskAsUndone();
        assertFalse(deadline.isDone(), "Task should be undone after markTaskAsUndone()");
    }

    @Test
    public void testPrintTask() {
        Deadlines deadline = new Deadlines("submit report", "12/12/2025 1200");

        String expected = "[D][ ] submit report (by :12/12/2025 1200)";
        assertEquals(expected, deadline.printTask(), "printTask() should match expected format");
    }
}