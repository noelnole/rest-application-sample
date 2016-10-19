package reprogramando.service;

import reprogramando.model.User;

import java.util.Optional;

/**
 * User service interface
 *
 * @author  Noel Rodriguez
 */
public interface UserService {

    /**
     * Find user by username
     * @param username
     * @return Optional user
     */
    Optional<User> findByUsername(String username);

    /**
     * Save a user
     *
     * @param user
     * @return User
     */
    User saveUser(User user);
}
