package br.com.dbufalo.financesapi.errors;

import java.time.LocalDateTime;

public class DuplicatedUniqueKey extends RuntimeException {


    private final String message;
    private final LocalDateTime timestamp;

    public DuplicatedUniqueKey(String messsage) {
        super();
        this.message = messsage;
        this.timestamp = LocalDateTime.now();
    }
}
