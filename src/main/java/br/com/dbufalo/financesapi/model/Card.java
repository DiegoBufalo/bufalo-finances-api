package br.com.dbufalo.financesapi.model;

import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Builder
@RegisterForReflection
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "card")
public class Card {

    @Id
    @SequenceGenerator(name = "card_sequence", sequenceName = "card_sequence_id")
    @GeneratedValue(generator = "card_sequence")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "checking_account_amount")
    private Double checkingAccountAmount;

    @ManyToOne
    @JoinColumn(name = "wallet_id", nullable = false, referencedColumnName = "id")
    private Wallet wallet;

    //transients
    @Transient
    @OneToMany(mappedBy = "card")
    private List<Debts> debts;

}
