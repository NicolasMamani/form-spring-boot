package com.bolsaideas.springbootform.models.domain;

import jakarta.validation.constraints.NotEmpty;

public class Usuario {
    @NotEmpty //valida que el String sea distinto de null y que no sea vacio ""
    private String username;
    @NotEmpty
    private String password;
    @NotEmpty
    private String email;


    //    Getters and setter
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
