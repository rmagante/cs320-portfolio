package test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import task.Task;
import task.TaskService;

public class TaskServiceTest {

    @Test
    public void testAddTaskSuccess() {
        TaskService service = new TaskService();
        Task task = new Task("1", "TaskName", "TaskDesc");

        service.addTask(task);

        Assertions.assertNotNull(service.getTask("1"));
        Assertions.assertEquals("TaskName", service.getTask("1").getName());
    }

    @Test
    public void testAddTaskDuplicateId() {
        TaskService service = new TaskService();
        service.addTask(new Task("1", "A", "Desc"));
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            service.addTask(new Task("1", "B", "Desc2"));
        });
    }

    @Test
    public void testDeleteTaskSuccess() {
        TaskService service = new TaskService();
        service.addTask(new Task("1", "A", "Desc"));

        service.deleteTask("1");

        Assertions.assertNull(service.getTask("1"));
    }

    @Test
    public void testDeleteTaskMissingId() {
        TaskService service = new TaskService();
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            service.deleteTask("999");
        });
    }

    @Test
    public void testUpdateNameSuccess() {
        TaskService service = new TaskService();
        service.addTask(new Task("1", "Old", "Desc"));

        service.updateTaskName("1", "New");

        Assertions.assertEquals("New", service.getTask("1").getName());
    }

    @Test
    public void testUpdateDescriptionSuccess() {
        TaskService service = new TaskService();
        service.addTask(new Task("1", "Name", "OldDesc"));

        service.updateTaskDescription("1", "NewDesc");

        Assertions.assertEquals("NewDesc", service.getTask("1").getDescription());
    }

    @Test
    public void testUpdateMissingId() {
        TaskService service = new TaskService();
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            service.updateTaskName("999", "Name");
        });
    }
}
