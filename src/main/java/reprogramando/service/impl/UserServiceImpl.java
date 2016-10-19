package reprogramando.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reprogramando.model.User;
import reprogramando.repository.UserRepository;
import reprogramando.service.UserService;

import java.util.Optional;

/**
 * @author Noel Rodriguez
 */

@Service
public class UserServiceImpl implements UserService{

    private static UserRepository userRepository;

    @Autowired
    public UserServiceImpl (UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }
}
