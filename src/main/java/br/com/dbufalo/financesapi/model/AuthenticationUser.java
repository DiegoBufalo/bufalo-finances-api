package br.com.dbufalo.financesapi.model;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import io.quarkus.security.jpa.Password;
import io.quarkus.security.jpa.Roles;
import io.quarkus.security.jpa.UserDefinition;
import io.quarkus.security.jpa.Username;

import javax.persistence.*;

@Entity
@Table(name = "authentication_user")
@UserDefinition
public class AuthenticationUser extends PanacheEntityBase {
    @Id
    @SequenceGenerator(name = "authentication_user_sequence", sequenceName = "authentication_user_sequence_id")
    @GeneratedValue(generator = "authentication_user_sequence")
    private Long id;
    @Username
    public String username;
    @Password
    public String password;
    @Roles
    public String role;

    @OneToOne(targetEntity = User.class, mappedBy = "authentication")
    public User user;
}
