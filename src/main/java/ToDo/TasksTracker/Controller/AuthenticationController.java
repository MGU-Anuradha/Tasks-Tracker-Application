package ToDo.TasksTracker.Controller;


import ToDo.TasksTracker.Payload.Request.AuthenticationRequest;
import ToDo.TasksTracker.Payload.Request.RegisterRequest;
import ToDo.TasksTracker.Payload.Response.AuthenticationResponse;
import ToDo.TasksTracker.Services.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    @Autowired
    private final AuthenticationService authenticationService;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterRequest request) { //takes in an HTTP request body (typically in JSON format) and maps it to a RegisterRequest object using @RequestBody
        return ResponseEntity.ok(authenticationService.register(request));
    }
//    @PostMapping("/registerAdmin")
//    public ResponseEntity<String> registerAdmin(@RequestBody RegisterRequest request) {
//        return ResponseEntity.ok(authenticationService.registerAdmin(request));
//    }
//    @PostMapping("/authenticate")
//    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request) {
//        return ResponseEntity.ok(authenticationService.authenticate(request));
//    }

    @GetMapping(path = "/confirm")
    public String confirm(@RequestParam("token") String token) {
        return authenticationService.confirmToken(token);
    }
}

