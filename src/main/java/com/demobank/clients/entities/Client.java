package com.demobank.clients.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;

@Entity
@Table(
        uniqueConstraints = {
                @UniqueConstraint(name = "uk_clients_client_id", columnNames = "client_id")
        }
)
public class Client extends Person {
    @Column(nullable = false, length = 250, unique = true)
    private String clientId;

    @Column(nullable = false, length = 250)
    private String password;

    @Column(nullable = false)
    @ColumnDefault("true")
    private boolean status;

    public String getClientId() {
        return clientId;
    }
    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean getStatus() {
        return status;
    }
    public void setStatus(boolean status) {
        this.status = status;
    }
}
