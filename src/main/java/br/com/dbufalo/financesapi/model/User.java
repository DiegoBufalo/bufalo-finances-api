package br.com.dbufalo.financesapi.model;

import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Builder
@RegisterForReflection
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user")
public class User {

    @Id
    @SequenceGenerator(name = "user_sequence", sequenceName = "user_sequence_id")
    @GeneratedValue(generator = "user_sequence")
    @Column(name = "id")
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @OneToOne(targetEntity = AuthenticationUser.class)
    @JoinColumn(name = "authentication_id", referencedColumnName = "id")
    private AuthenticationUser authentication;

    @OneToOne(mappedBy = "user")
    private Wallet wallet;
}