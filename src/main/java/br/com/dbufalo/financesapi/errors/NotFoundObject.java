package br.com.dbufalo.financesapi.errors;

import java.time.LocalDateTime;

public class NotFoundObject extends RuntimeException {


    private final String message;
    private final LocalDateTime timestamp;

    public NotFoundObject(String messsage) {
        super();
        this.message = messsage;
        this.timestamp = LocalDateTime.now();
    }
}
