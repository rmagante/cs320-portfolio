package task;

import java.util.HashMap;
import java.util.Map;

/**
 * Service class for managing Task objects in-memory.
 * Supports adding, deleting, and updating task fields by taskId.
 */
public class TaskService {

    private final Map<String, Task> tasks = new HashMap<>();

    /**
     * Adds a new task. Task IDs must be unique.
     *
     * @param task the Task to add
     * @throws IllegalArgumentException if task is null or ID already exists
     */
    public void addTask(Task task) {
        if (task == null) {
            throw new IllegalArgumentException("Task cannot be null");
        }

        String taskId = task.getTaskId();
        if (tasks.containsKey(taskId)) {
            throw new IllegalArgumentException("Task ID already exists");
        }

        tasks.put(taskId, task);
    }

    /**
     * Deletes a task by taskId.
     *
     * @param taskId the ID of the task to delete
     * @throws IllegalArgumentException if taskId is null or not found
     */
    public void deleteTask(String taskId) {
        if (taskId == null || !tasks.containsKey(taskId)) {
            throw new IllegalArgumentException("Task ID not found");
        }

        tasks.remove(taskId);
    }

    /**
     * Updates the name of a task by taskId.
     *
     * @param taskId the ID of the task
     * @param name   the new name
     * @throws IllegalArgumentException if taskId invalid or name invalid
     */
    public void updateTaskName(String taskId, String name) {
        Task task = getTaskOrThrow(taskId);
        task.setName(name);
    }

    /**
     * Updates the description of a task by taskId.
     *
     * @param taskId      the ID of the task
     * @param description the new description
     * @throws IllegalArgumentException if taskId invalid or description invalid
     */
    public void updateTaskDescription(String taskId, String description) {
        Task task = getTaskOrThrow(taskId);
        task.setDescription(description);
    }

    /**
     * Retrieves a task by taskId.
     * Used primarily for testing.
     *
     * @param taskId the ID of the task
     * @return the Task if found, otherwise null
     */
    public Task getTask(String taskId) {
        return tasks.get(taskId);
    }

    /**
     * Internal helper to retrieve a task or throw if invalid.
     *
     * @param taskId the ID of the task
     * @return existing Task
     * @throws IllegalArgumentException if taskId is null or not found
     */
    private Task getTaskOrThrow(String taskId) {
        if (taskId == null || !tasks.containsKey(taskId)) {
            throw new IllegalArgumentException("Task ID not found");
        }
        return tasks.get(taskId);
    }
}