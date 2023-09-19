package ToDo.TasksTracker.Controller;

import ToDo.TasksTracker.Model.Tasks;
import ToDo.TasksTracker.Payload.Request.TaskRequest;
import ToDo.TasksTracker.Payload.Request.TaskUpdateRequest;
import ToDo.TasksTracker.Services.TasksService;
import org.springframework.ui.Model;
import org.springframework.security.core.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TasksController {
    @Autowired
    TasksService taskService;

    @PostMapping("/add")
    public String loginSuccess(Model model, Authentication authentication, @RequestBody TaskRequest taskRequest) {
        // Get the currently logged-in user's email
        String userEmail = authentication.getName();

        // Create the task for the logged-in user
        boolean taskCreated = taskService.createTaskForEmail(userEmail, taskRequest);

        if (taskCreated) {
            // Task created successfully
            model.addAttribute("message", "Task created successfully.");
        } else {
            // Task creation failed
            model.addAttribute("message", "Failed to create the task.");
        }

        // Redirect to a success page or display a message to the user
        return "success-page";
    }

    @GetMapping("/all-tasks")
    public List<Tasks> getUserTasks(Authentication authentication) {
        // Get the currently logged-in user's email
        String userEmail = authentication.getName();

        // Retrieve tasks associated with the user's email
        List<Tasks> userTasks = taskService.getTasksByEmail(userEmail);

        return userTasks;
    }

    @PutMapping("/update")
    public ResponseEntity<String> updateTask(@RequestBody TaskUpdateRequest updateRequest) {
        // You can include the task ID and completed status in TaskUpdateRequest.
        boolean taskUpdated = taskService.updateTaskCompletion(updateRequest.getTaskId(), updateRequest.isCompleted());

        if (taskUpdated) {
            return ResponseEntity.ok("Task updated successfully.");
        } else {
            return ResponseEntity.badRequest().body("Failed to update task.");
        }
    }
}
