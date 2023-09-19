package ToDo.TasksTracker.Repository;

import ToDo.TasksTracker.Model.Tasks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TasksRepository extends JpaRepository<Tasks, Long> {
//    // Define custom query methods if needed
//    @Override
//    <S extends Tasks> S save(S entity);

    List<Tasks> findByEmail(String email);
}
