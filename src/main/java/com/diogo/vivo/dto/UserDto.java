package com.diogo.vivo.dto;

import jakarta.validation.constraints.Email;

import java.io.Serializable;

public class UserDto implements Serializable {
    private static final long serialVersionUID = 1L;

    private String name;
    @Email
    private String email;
    private String document;

    public UserDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }
}
