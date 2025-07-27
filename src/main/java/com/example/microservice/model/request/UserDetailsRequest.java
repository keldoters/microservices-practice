package com.example.microservice.model.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.context.annotation.EnableMBeanExport;

public class UserDetailsRequest {
    @NotNull(message="first name cannot not be null")
    private String firstName;

    @NotNull(message="last name cannot not be null")
    private String lastName;

    @NotNull(message="email cannot not be null")
    @Email
    private String email;

    @NotNull(message="password cannot not be null")
    @Size(min = 8, max = 16, message = "password character must be equal or greater than 8 characters and less than 16 characters")
    private String password;

    public UserDetailsRequest(String firstName, String lastName, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
