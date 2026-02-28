package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import task.Task;

/**
 * Unit tests for the Task class.
 * Verifies that Task enforces all required field constraints through
 * constructor validation and setter validation.
 */
public class TaskTest {

    @Test
    void testTaskCreationSuccess() {
        Task task = new Task("12345", "Workout", "Leg day. No skipping.");
        assertEquals("12345", task.getTaskId());
        assertEquals("Workout", task.getName());
        assertEquals("Leg day. No skipping.", task.getDescription());
    }

    @Test
    void testMaxLengthsAllowed() {
        String id10 = "1234567890"; // 10 chars
        String name20 = "12345678901234567890"; // 20 chars
        String desc50 = "12345678901234567890123456789012345678901234567890"; // 50 chars

        Task task = new Task(id10, name20, desc50);

        assertEquals(id10, task.getTaskId());
        assertEquals(name20, task.getName());
        assertEquals(desc50, task.getDescription());
    }

    @Test
    void testTaskIdTooLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Task("12345678901", "Name", "Desc");
        });
    }

    @Test
    void testNameTooLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Task("12345", "123456789012345678901", "Desc"); // 21 chars
        });
    }

    @Test
    void testDescriptionTooLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Task("12345", "Name", "123456789012345678901234567890123456789012345678901"); // 51 chars
        });
    }

    @Test
    void testNullFields() {
        assertThrows(IllegalArgumentException.class, () -> new Task(null, "Name", "Desc"));
        assertThrows(IllegalArgumentException.class, () -> new Task("12345", null, "Desc"));
        assertThrows(IllegalArgumentException.class, () -> new Task("12345", "Name", null));
    }

    @Test
    void testSettersValidate() {
        Task task = new Task("12345", "Workout", "Leg day. No skipping.");

        task.setName("Run");
        assertEquals("Run", task.getName());

        task.setDescription("Short desc");
        assertEquals("Short desc", task.getDescription());

        assertThrows(IllegalArgumentException.class, () -> task.setName(null));
        assertThrows(IllegalArgumentException.class, () -> task.setName("123456789012345678901")); // 21 chars

        assertThrows(IllegalArgumentException.class, () -> task.setDescription(null));
        assertThrows(IllegalArgumentException.class,
                () -> task.setDescription("123456789012345678901234567890123456789012345678901")); // 51 chars
    }
}