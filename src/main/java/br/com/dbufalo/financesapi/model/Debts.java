package br.com.dbufalo.financesapi.model;


import br.com.dbufalo.financesapi.enums.Category;
import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@Builder
@RegisterForReflection
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "debt")
public class Debts {

    @Id
    @SequenceGenerator(name = "debt_sequence", sequenceName = "debt_sequence_id")
    @GeneratedValue(generator = "debt_sequence")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "card_id", referencedColumnName = "id")
    private Card card;

    @Column(name = "amount")
    private Double amount;

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "total_of_installments")
    private Integer totalOfInstallments;

    @Column(name = "actual_installment")
    private Integer actualInstallment;

    @Column(name = "category")
    @Enumerated(EnumType.STRING)
    private Category category;
}
