package com.diogo.vivo.controllers;

import com.diogo.vivo.controllers.api.UserApi;
import com.diogo.vivo.dto.UserDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController implements UserApi {
    @Override
    public ResponseEntity<UserDto> getAllUsers() {
        return null;
    }
}
