package com.diogo.vivo.controllers.api;

import com.diogo.vivo.dto.UserDto;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value ="/users")
public interface UserApi {

    @GetMapping
    ResponseEntity<List<UserDto>> getAllUsers();

    @GetMapping(value ="/{email}")
    ResponseEntity<UserDto>getByEmail(@PathVariable String email);

    @PostMapping
    ResponseEntity<Void> insertUser(@Valid @RequestBody UserDto user);
}
