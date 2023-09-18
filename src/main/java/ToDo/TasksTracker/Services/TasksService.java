package ToDo.TasksTracker.Services;

import ToDo.TasksTracker.Model.Tasks;
import ToDo.TasksTracker.Repository.TasksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TasksService {
    @Autowired
    TasksRepository taskRepository;

    public List<Tasks> getAllTasks() {
        return taskRepository.findAll();
    }

    // Other business logic...
}

