package ToDo.TasksTracker.Services;

import ToDo.TasksTracker.Model.Tasks;
import ToDo.TasksTracker.Payload.Request.TaskRequest;
import ToDo.TasksTracker.Repository.TasksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TasksService {
    @Autowired
    TasksRepository taskRepository;

    // Other business logic...
    public boolean createTaskForEmail(String email, TaskRequest request) {
        Tasks task = new Tasks();
        task.setEmail(email);
        task.setTitle(request.getTitle());
        task.setDescription(request.getDescription());
        task.setCategory(request.getCategory());
        task.setCompleted(request.getCompleted());
        //task.setDueDate(request.getDueDate());

        try {
            taskRepository.save(task);
            return true; // Task created successfully.
        } catch (Exception e) {
            e.printStackTrace();
            return false; // Failed to create the task.
       }
    }

    // Other service methods...
    public List<Tasks> getTasksByEmail(String email) {
        return taskRepository.findByEmail(email);
    }

    public boolean updateTaskCompletion(Long taskId, boolean completed) {
        try {
            // Validate if taskId is not null
            if (taskId == null) {
                return false; // Invalid taskId
            }
            // Retrieve the task from the database by its ID
            Optional<Tasks> optionalTask = taskRepository.findById(taskId);

            if (optionalTask.isPresent()) {
                Tasks task = optionalTask.get();

                // Update the completed status
                task.setCompleted(completed);

                // Save the updated task back to the database
                taskRepository.save(task);

                return true; // Task updated successfully.
            } else {
                // Task with the given ID not found
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false; // Failed to update the task.
        }
    }

    // Other service methods...

}

