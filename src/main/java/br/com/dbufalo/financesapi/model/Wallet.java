package br.com.dbufalo.financesapi.model;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
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
@Table(name = "wallet")
public class Wallet extends PanacheEntityBase  {

    @Id
    @SequenceGenerator(name = "wallet_sequence", sequenceName = "wallet_sequence_id")
    @GeneratedValue(generator = "wallet_sequence")
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "cash_value")
    private Double cashValue;


    //transients
    @OneToMany(mappedBy = "wallet")
    private List<Card> cards;

    @Transient
    public Double getTotalAmount() {
        Double total = this.cashValue;
        for (Card card : this.cards) {
            total += card.getCheckingAccountAmount();
        }
        return total;
    }

    @Transient
    public void incrementCashAmount(Double amount) {
        this.cashValue += amount;
    }

    @Transient
    public void decrementCashAmount(Double amount) {
        this.cashValue -= amount;
    }
}
