package ToDo.TasksTracker.Controller;

import ToDo.TasksTracker.Model.Users;
import ToDo.TasksTracker.Services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UsersController {
    @Autowired
    private UsersService userService;
    public ResponseEntity<Users> getUserDetailsById(@RequestParam Integer id) {
        Optional<Users> user= userService.findByUserId(id);
        return ResponseEntity.ok(user.get());
    }
}

