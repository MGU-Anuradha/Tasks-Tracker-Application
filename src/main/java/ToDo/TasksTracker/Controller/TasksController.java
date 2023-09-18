package ToDo.TasksTracker.Controller;

import ToDo.TasksTracker.Model.Tasks;
import ToDo.TasksTracker.Services.TasksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TasksController {
    @Autowired
    TasksService taskService;

    @GetMapping("/all")
    public List<Tasks> getAllTasks() {
        return taskService.getAllTasks();
    }

    // Other controller methods...
}
