package com.diogo.vivo.controllers;

import com.diogo.vivo.controllers.api.UserApi;
import com.diogo.vivo.dto.UserDto;
import com.diogo.vivo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController implements UserApi {

    @Autowired
    private UserService userService;

    @Override
    public ResponseEntity<List<UserDto>> getAllUsers() {
        List<UserDto> list = userService.getAllUsers();
        return ResponseEntity.ok().body(list);
    }

    @Override
    public ResponseEntity<UserDto> getByEmail(@PathVariable String email) {
        UserDto user = userService.getByEmail(email);
        return ResponseEntity.ok().body(user);
    }
}
