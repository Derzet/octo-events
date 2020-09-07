package com.voyager.mt.octo.config.error;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class ApiError {
    private List<String> errors;
    private LocalDateTime timestamp;
    private int status;

    public ApiError(List<String> errors, HttpStatus status) {
        this.errors = errors;
        this.timestamp = LocalDateTime.now();
        this.status = status.value();
    }
}
