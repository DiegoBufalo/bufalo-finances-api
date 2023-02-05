package br.com.dbufalo.financesapi.repository;

import br.com.dbufalo.financesapi.model.User;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

import javax.enterprise.context.ApplicationScoped;
import java.util.Optional;

@ApplicationScoped
public class UserRepository implements PanacheRepositoryBase<User, Long> {

    public Optional<User> findByUsername(String username) {
        return find("authentication.username", username).firstResultOptional();
    }
}
