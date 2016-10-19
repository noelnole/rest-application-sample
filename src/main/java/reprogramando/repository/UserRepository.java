package reprogramando.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import reprogramando.model.User;

import java.util.Optional;

/**
 * User repository
 *
 * @author Noel Rodriguez
 */
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);
}
