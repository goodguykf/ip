package friday.tasks;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Represents the class the test Deadline class.
 */
public class DeadlinesTest {
    /**
     * Test if the method testMarkAsDone is working as intended.
     */
    @Test
    public void testMarkAsDone() {
        Deadlines deadline = new Deadlines("submit report", "12/12/2025 1200");

        // Initially, the task should not be done
        assertFalse(deadline.isDone(), "Task should start as not done");

        // Mark the task as done
        deadline.markTaskAsDone();
        assertTrue(deadline.isDone(), "Task should be done after markTaskAsDone()");
    }

    /**
     * Test if the method testMarkAsUndone is working as intended.
     */
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

    /**
     * Test if the method testPrintTask is working as intended.
     */
    @Test
    public void testPrintTask() {
        Deadlines deadline = new Deadlines("submit report", "12/12/2025 1200");

        String expected = "[D][ ] submit report (by :12/12/2025 1200)";
        assertEquals(expected, deadline.taskAsString(), "taskAsString() should match expected format");
    }
}