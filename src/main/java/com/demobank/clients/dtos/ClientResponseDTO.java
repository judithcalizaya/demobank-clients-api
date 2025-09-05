package com.demobank.clients.dtos;

import com.demobank.clients.entities.Gender;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

import java.util.Date;

public class ClientResponseDTO {
    @NotBlank @Size(max = 250)
    private String firstName;

    @NotBlank @Size(max = 250)
    private String lastName;

    @NotBlank @Size(max = 250)
    private String nationalId;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @NotNull
    @Past(message="birthdate must be in the past.")
    private Date birthdate;

    @NotNull(message = "gender is required")
    private Gender gender;

    @NotBlank @Size(max = 250)
    private String address;

    @NotBlank @Size(max = 250)
    private String phoneNumber;

    private String clientId;

    @NotBlank
    private String password;

    private boolean status = true;

    public String getClientId() {
        return clientId;
    }
    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getNationalId() {
        return nationalId;
    }

    public void setNationalId(String nationalId) {
        this.nationalId = nationalId;
    }

    public Date getBirthdate() {
        return birthdate;
    }
    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public Gender getGender() {
        return gender;
    }
    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    public boolean isStatus() {
        return status;
    }
}
