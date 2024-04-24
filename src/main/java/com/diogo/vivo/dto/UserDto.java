package com.diogo.vivo.dto;

import com.diogo.vivo.models.UserModel;
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

    public UserDto(UserModel user) {
        this.name = user.getName();
        this.email = user.getEmail();
        this.document = user.getDocument();
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
