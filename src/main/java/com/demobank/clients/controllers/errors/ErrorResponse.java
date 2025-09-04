package com.demobank.clients.controllers.errors;

import java.time.Instant;

public class ErrorResponse {
    private String code;
    private String message;
    private Instant timestamp;

    public ErrorResponse(final String code,
                         final String message,
                         final Instant timestamp) {
        this.code = code;
        this.message = message;
        this.timestamp = timestamp;
    }

    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }

    public Instant getTimestamp() {
        return timestamp;
    }
    public void setTimestamp(Instant timestamp) {
        this.timestamp = timestamp;
    }
}
