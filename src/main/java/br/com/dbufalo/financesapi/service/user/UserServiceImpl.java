package br.com.dbufalo.financesapi.service.user;

import br.com.dbufalo.financesapi.records.CreateUserDTO;
import br.com.dbufalo.financesapi.dto.UserDTO;
import br.com.dbufalo.financesapi.errors.NotFoundObject;
import br.com.dbufalo.financesapi.model.AuthenticationUser;
import br.com.dbufalo.financesapi.model.User;
import br.com.dbufalo.financesapi.model.Wallet;
import br.com.dbufalo.financesapi.repository.UserRepository;
import io.quarkus.elytron.security.common.BcryptUtil;
import org.hibernate.Hibernate;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public UserDTO getUser(Long id) {
        return userRepository.findByIdOptional(id).map(UserDTO::fromEntity).orElseGet(UserDTO::new);
    }

    @Override
    @Transactional
    public UserDTO createUser(CreateUserDTO userDTO) {
        // generate authenticator
        AuthenticationUser auth = addAuthenticatorUser(userDTO.username(), userDTO.password(), userDTO.role());

        //generate user
        User user = User.builder()
                .name(userDTO.name())
                .authentication(auth)
                .build();
        userRepository.persistAndFlush(user);

        //generate a default wallet
        Wallet wallet = Wallet.builder()
                .cashValue(0.0)
                .cards(List.of())
                .user(user)
                .build();
        wallet.persist();

        //send the persisted info
        user.setWallet(wallet);
        return UserDTO.fromEntity(user);
    }

    @Override
    @Transactional
    public void removeUser(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public UserDTO getUserByUsername(String username) {
        User user = userRepository.findByUsername(username).orElseThrow(() ->
                new NotFoundObject("Usuário não encontrado")
        );
        return UserDTO.fromEntity(user);
    }

    /**
     * Adds a new user to the database
     *
     * @param username the username
     * @param password the unencrypted password (it will be encrypted with bcrypt)
     * @param role     the comma-separated roles
     */
    private static AuthenticationUser addAuthenticatorUser(String username, String password, String role) {
        AuthenticationUser user = new AuthenticationUser();
        user.username = username;
        user.password = BcryptUtil.bcryptHash(password);
        user.role = role;
        user.persistAndFlush();
        return user;
    }
}
