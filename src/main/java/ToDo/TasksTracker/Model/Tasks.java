package ToDo.TasksTracker.Model;
import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tasks")
public class Tasks {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        @Column(nullable = false)
        private String title;
        @Column(nullable = false)
        private String description;

//        @Column(nullable = false)
//        private Date dueDate;
        @Column(nullable = false)
        private String category;
        @Column(nullable = false)
        private Boolean completed;

    // Constructors, getters, and setters

    public Tasks() {
        // Default constructor
    }

    public Tasks(String title, String description, Date dueDate, String category, Boolean completed) {
        this.title = title;
        this.description = description;
//        this.dueDate = dueDate;
        this.category = category;
        this.completed = completed;
    }

    // Getters and setters for all fields

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

//    public Date getDueDate() {
//        return dueDate;
//    }
//
//    public void setDueDate(Date dueDate) {
//        this.dueDate = dueDate;
//    }

    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }

    public Boolean getCompleted() {
        return completed;
    }
    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }
}


