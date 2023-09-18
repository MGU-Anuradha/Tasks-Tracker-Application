package ToDo.TasksTracker.Token;

import ToDo.TasksTracker.Model.Users;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Token {

    @Id
    @GeneratedValue
    public Integer id;

    @Column(unique = true)
    public String token;

    @Enumerated(EnumType.STRING)
    public TokenType tokenType = TokenType.BEARER;

    public boolean revoked;
    public boolean expired;
    public LocalDateTime confirmedAt;
    public LocalDateTime expiredAt;

    @ManyToOne(fetch = FetchType.LAZY) //had to add the fetching type as lazy
    @JoinColumn(name = "user_id")
    public Users user;
}

