package com.diogo.vivo.controllers.api;

import com.diogo.vivo.dto.UserDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value ="/users")
public interface UserApi {

    @GetMapping
    ResponseEntity<List<UserDto>> getAllUsers();
}
