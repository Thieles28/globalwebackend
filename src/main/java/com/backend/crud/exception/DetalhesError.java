package com.backend.crud.exception;

import java.util.Date;

public class DetalhesError {
    private Date timestamp;
    private String message;
    private String detalhes;

    public DetalhesError(Date timestamp, String message, String detalhes) {
        super();
        this.timestamp = timestamp;
        this.message = message;
        this.detalhes = detalhes;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public String getMessage() {
        return message;
    }

    public String getDetalhes() {
        return detalhes;
    }
}
