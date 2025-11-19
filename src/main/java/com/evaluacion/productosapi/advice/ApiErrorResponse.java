package com.evaluacion.productosapi.advice;

import org.springframework.http.HttpStatus;
import java.time.LocalDateTime;

public class ApiErrorResponse {

    private final String error;
    private final String descripcion;
    private final LocalDateTime timestamp;
    private final int status;

    public ApiErrorResponse(String error, String descripcion, HttpStatus status) {
        this.error = error;
        this.descripcion = descripcion;
        this.timestamp = LocalDateTime.now();
        this.status = status.value();
    }

    public String getError() {
        return error;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public int getStatus() {
        return status;
    }
}