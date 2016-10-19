package reprogramando.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityLinks;
import org.springframework.hateoas.ExposesResourceFor;
import org.springframework.hateoas.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reprogramando.model.User;
import reprogramando.service.UserService;

import javax.validation.Valid;
import java.util.Optional;

/**
 * User controller with HATEOAS
 *
 * @author  Noel Rodriguez
 */

@RestController
@RequestMapping(value="/user")
//What model manage the controller
@ExposesResourceFor(User.class)
public class UserController {

    private static UserService userService;

   // The EntityLinks interface now exposes an API to lookup a Link or LinkBuilder based on the model types
    private final EntityLinks entityLinks;

    @Autowired
    public UserController (UserService userService, EntityLinks entityLinks){
        this.userService = userService;
        this.entityLinks = entityLinks;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Resource<User>> findUserByUsername (@RequestParam  String username){
        Optional<User> user = this.userService.findByUsername(username);
        if (user.isPresent()) {
            Resource<User> resources = new Resource<User>(user.get());
            resources.add(this.entityLinks.linkToCollectionResource(User.class));
            return new ResponseEntity<Resource<User>>(resources, HttpStatus.OK);
        }
        return new ResponseEntity(new User(), HttpStatus.NO_CONTENT);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<User> saveUser (@RequestBody @Valid User user){
        return new ResponseEntity<User>( userService.saveUser(user), HttpStatus.CREATED);
    }

}
