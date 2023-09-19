package ToDo.TasksTracker.Payload.Request;

public class TaskUpdateRequest {
    private Long taskId;
    private boolean completed;

    // Constructors, getters, and setters

    public Long getTaskId() {
        return taskId;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}
