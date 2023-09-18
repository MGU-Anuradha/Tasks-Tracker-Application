package ToDo.TasksTracker.Repository;

import ToDo.TasksTracker.Model.Tasks;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TasksRepository extends JpaRepository<Tasks, Long> {
    // Define custom query methods if needed
}
