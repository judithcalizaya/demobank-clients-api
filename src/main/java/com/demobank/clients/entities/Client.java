package com.demobank.clients.entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Client extends Person {
    @Column(unique = true)
    private String clientId;
    private String password;
    private boolean status;

    public String getClientId() {
        return clientId;
    }
    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public boolean getStatus() {
        return status;
    }
    public void setStatus(boolean status) {
        this.status = status;
    }
}
