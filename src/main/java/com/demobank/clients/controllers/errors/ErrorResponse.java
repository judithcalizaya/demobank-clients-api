package com.demobank.clients.controllers.errors;

import java.time.Instant;
import java.util.List;
import java.util.Map;

public class ErrorResponse {
    private String code;
    private String message;
    private Instant timestamp;
    private Map<String, List<String>> errors;

    public ErrorResponse(final String code,
                         final String message,
                         final Instant timestamp) {
        this.code = code;
        this.message = message;
        this.timestamp = timestamp;
    }

    public ErrorResponse(final String code,
                         final String message,
                         final Instant timestamp,
                         final Map<String, List<String>> errors) {
        this.code = code;
        this.message = message;
        this.timestamp = timestamp;
        this.errors = errors;
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

    public Map<String, List<String>> getErrors() {
        return errors;
    }
    public void setErrors(Map<String, List<String>> errors) {
        this.errors = errors;
    }

}
