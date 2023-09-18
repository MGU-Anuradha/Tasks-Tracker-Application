package ToDo.TasksTracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
@SpringBootApplication
public class TasksTrackerApplication {

	public static void main(String[] args) {

		SpringApplication.run(TasksTrackerApplication.class, args);
	}

}
