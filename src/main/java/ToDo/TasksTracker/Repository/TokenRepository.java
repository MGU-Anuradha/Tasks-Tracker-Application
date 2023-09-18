package ToDo.TasksTracker.Repository;


import ToDo.TasksTracker.Token.Token;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface TokenRepository extends JpaRepository<Token, Integer> {

    @Query("SELECT t FROM Token t INNER JOIN t.user u WHERE u.id = :id AND (t.expired = false OR t.revoked = false)") // formatted the query
    List<Token> findAllValidTokenByUser(@Param("id") Integer id);



    Optional<Token> findByToken(String token);
    @Transactional
    @Modifying
    @Query("UPDATE Token c " + "SET c.confirmedAt = ?2 " + "WHERE c.token = ?1")
    int updateConfirmedAt(String token,
                          LocalDateTime confirmedAt);

    @Modifying
    @Query("DELETE FROM Token t WHERE t.user.id = ?1")
    int deleteTokenByUserId(int userId);
}
