package ToDo.TasksTracker.Services;

import ToDo.TasksTracker.Model.Users;
import ToDo.TasksTracker.Repository.UsersRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UsersService implements UserDetailsService {
    private final UsersRepository userRepository;
    private static final String USER_NOT_FOUND_MSG = "user with email %s not found";
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepository.findByEmail(email).orElseThrow(()-> new UsernameNotFoundException(String.format(USER_NOT_FOUND_MSG,email)));
    }
    public List<Users> getAllUser() {
        return userRepository.findAll();
    }
    public Optional<Users> findByUserId(int id) {
        return userRepository.findById(id);
    }
    // Add a method to delete a user by email

    public void deleteUserByEmail(String email) {
        Optional<Users> user = userRepository.findByEmail(email);
        if (user.isPresent()) {
            userRepository.delete(user.get());
        } else {
            throw new IllegalArgumentException("User not found");
        }
    }


}
