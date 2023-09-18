package ToDo.TasksTracker.Model;

import ToDo.TasksTracker.Token.Token;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users",uniqueConstraints = {@UniqueConstraint(name = "email",columnNames ={"email"} )})
public class Users implements UserDetails {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private String email;
    private String password;
    private boolean verified;
    @OneToMany(mappedBy = "user")
    private List<Token> tokens;

    public Users(String name, String email, String password, boolean verified,List<Token> tokens) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.verified = verified;
        this.tokens = tokens;
    }

    // Getter Setter Methods....

    public String getName() {
        return name;
    }
    public String getEmail() {
        return email;
    }
    public boolean isVerified() {
        return verified;
    }
    public List<Token> getTokens() {
        return tokens;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return verified;
    }
}
