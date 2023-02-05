package br.com.dbufalo.financesapi.rest;

import br.com.dbufalo.financesapi.records.CreateUserDTO;
import br.com.dbufalo.financesapi.dto.UserDTO;
import br.com.dbufalo.financesapi.service.user.UserService;
import org.jboss.resteasy.reactive.RestPath;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import static br.com.dbufalo.financesapi.defaults.Constants.BASE_URL;

@Path(BASE_URL + "/users")
public class UserController {

    @Inject
    UserService userService;

    @GET
    @Path(("/{userId}"))
    @Produces(MediaType.APPLICATION_JSON)
    @RolesAllowed({"admin", "user"})
    public UserDTO getUser(@RestPath Long userId) {
        return userService.getUser(userId);
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @PermitAll
    public UserDTO createUser(CreateUserDTO userDTO) {
        return userService.createUser(userDTO);
    }

    @DELETE
    @Path("/{userId}")
    @RolesAllowed({"admin", "user"})
    public void removeUser(@RestPath Long userId) {
        userService.removeUser(userId);
    }
}
