package reprogramando.model;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;


/**
 * User information
 *
 * @author Noel Rodriguez
 */
@Entity
@Data
@Accessors(chain = true)
public class User {

    /**
     * Primary key
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /**
     * username
     */
    @NotNull
    private String username;

    /**
     * User password
     */
    @NotNull
    private String password;
}
