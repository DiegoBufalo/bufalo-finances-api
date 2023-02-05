package br.com.dbufalo.financesapi.service.user;

import br.com.dbufalo.financesapi.model.User;
import br.com.dbufalo.financesapi.records.CreateUserDTO;
import br.com.dbufalo.financesapi.dto.UserDTO;


public interface UserService {
    UserDTO getUser(Long id);

    UserDTO createUser(CreateUserDTO user);

    void removeUser(Long id);

    UserDTO getUserByUsername(String username);
}
