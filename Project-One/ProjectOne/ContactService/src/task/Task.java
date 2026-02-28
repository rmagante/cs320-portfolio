package task;

/**
 * Represents a Task in the mobile application.
 * A Task has a required, unique taskId and required fields for name and description.
 * All fields are validated to meet the project requirements.
 */
public class Task {

    /** Unique task identifier (not updatable). */
    private final String taskId;

    /** Task name (required, max 20 characters). */
    private String name;

    /** Task description (required, max 50 characters). */
    private String description;

    /**
     * Creates a Task with required fields and validates all inputs.
     *
     * @param taskId      unique task ID (required, max 10 characters)
     * @param name        task name (required, max 20 characters)
     * @param description task description (required, max 50 characters)
     * @throws IllegalArgumentException if any argument is null or violates length requirements
     */
    public Task(String taskId, String name, String description) {

        // taskId: required, not null, <= 10, not updatable
        if (taskId == null || taskId.length() > 10) {
            throw new IllegalArgumentException("Invalid task ID");
        }

        // name: required, not null, <= 20
        if (name == null || name.length() > 20) {
            throw new IllegalArgumentException("Invalid name");
        }

        // description: required, not null, <= 50
        if (description == null || description.length() > 50) {
            throw new IllegalArgumentException("Invalid description");
        }

        this.taskId = taskId;
        this.name = name;
        this.description = description;
    }

    /**
     * Returns the task ID (not updatable).
     *
     * @return taskId
     */
    public String getTaskId() {
        return taskId;
    }

    /**
     * Returns the task name.
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the task description.
     *
     * @return description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Updates the task name after validating requirements.
     *
     * @param name new name (required, max 20 characters)
     * @throws IllegalArgumentException if name is null or longer than 20 characters
     */
    public void setName(String name) {
        if (name == null || name.length() > 20) {
            throw new IllegalArgumentException("Invalid name");
        }
        this.name = name;
    }

    /**
     * Updates the task description after validating requirements.
     *
     * @param description new description (required, max 50 characters)
     * @throws IllegalArgumentException if description is null or longer than 50 characters
     */
    public void setDescription(String description) {
        if (description == null || description.length() > 50) {
            throw new IllegalArgumentException("Invalid description");
        }
        this.description = description;
    }
}