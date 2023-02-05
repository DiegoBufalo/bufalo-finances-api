package br.com.dbufalo.financesapi.records;

public record CreateUserDTO(
        String username,
        String password,
        String name,
        String role) {
}
