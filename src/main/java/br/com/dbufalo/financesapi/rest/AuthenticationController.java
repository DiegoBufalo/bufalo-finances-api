package br.com.dbufalo.financesapi.rest;


import br.com.dbufalo.financesapi.defaults.Constants;
import br.com.dbufalo.financesapi.dto.UserDTO;
import br.com.dbufalo.financesapi.model.AuthenticationUser;
import br.com.dbufalo.financesapi.service.user.UserService;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.annotation.security.RolesAllowed;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.SecurityContext;

@Path(Constants.BASE_URL + "/me")
@RequestScoped
public class AuthenticationController {

    @Inject
    UserService userService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @RolesAllowed({"admin", "user"})
    public UserDTO getMe(@Context SecurityContext securityContext) {
        return userService.getUserByUsername(securityContext.getUserPrincipal().getName());
    }
}
