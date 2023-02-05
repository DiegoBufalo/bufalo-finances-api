package br.com.dbufalo.financesapi.dto;

import br.com.dbufalo.financesapi.model.Wallet;
import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.*;

@Getter
@Setter
@Builder
@RegisterForReflection
@AllArgsConstructor
@NoArgsConstructor
public class WalletDTO {

    private Long id;
    private Double cashValue;

    private Double checkingAccountAmount;


    public static WalletDTO fromEntity(Wallet wallet) {
        return WalletDTO.builder()
                .id(wallet.getId())
                .cashValue(wallet.getCashValue())
                .checkingAccountAmount(wallet.getTotalAmount() - wallet.getCashValue())
                .build();
    }
}