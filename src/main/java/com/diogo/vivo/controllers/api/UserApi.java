package com.diogo.vivo.controllers.api;

import com.diogo.vivo.dto.UserDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value ="/user")
public interface UserApi {

    ResponseEntity<UserDto> getAllUsers();
}
