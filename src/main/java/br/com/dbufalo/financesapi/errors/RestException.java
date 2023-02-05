package br.com.dbufalo.financesapi.errors;

import io.netty.handler.codec.http.HttpResponseStatus;

import java.time.LocalDateTime;

public class RestException extends RuntimeException {


    private final String message;
    private final HttpResponseStatus status;
    private final LocalDateTime timestamp;

    public RestException(HttpResponseStatus status, String messsage) {
        super();
        this.status = status;
        this.message = messsage;
        this.timestamp = LocalDateTime.now();
    }
}
