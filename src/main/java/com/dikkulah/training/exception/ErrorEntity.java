package com.dikkulah.training.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Getter
@Setter
public class ErrorEntity {
    private String message;
    private HttpStatus httpStatus;
    private LocalDateTime localDateTime;


    public ErrorEntity(String message, HttpStatus httpStatus, LocalDateTime localDateTime) {
        this.message = message;
        this.httpStatus = httpStatus;
        this.localDateTime = localDateTime;
    }

    @Override
    public String toString() {
        return "ErrorEntity{" +
                "message='" + message + '\'' +
                ", localDateTime=" + localDateTime +
                '}';
    }
}
