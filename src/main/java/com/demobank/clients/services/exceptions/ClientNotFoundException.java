package com.demobank.clients.services.exceptions;

public class ClientNotFoundException extends RuntimeException {
    private final String clientId;

    public ClientNotFoundException(final String clientId) {
        super("The client with ID %s was not found".formatted(clientId));
        this.clientId = clientId;
    }
    public String getClientId() {
        return clientId;
    }
}
