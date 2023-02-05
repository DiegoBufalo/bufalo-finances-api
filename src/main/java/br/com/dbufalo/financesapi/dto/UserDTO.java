package br.com.dbufalo.financesapi.dto;

import br.com.dbufalo.financesapi.model.User;
import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.*;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@Builder
@RegisterForReflection
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    private Long id;

    @NotNull(message = "Nome obrigatório")
    private String name;

    private WalletDTO wallet;


    public static UserDTO fromEntity(User user) {
        return UserDTO.builder()
                .id(user.getId())
                .name(user.getName())
                .wallet(WalletDTO.fromEntity(user.getWallet()))
                .build();
    }
}