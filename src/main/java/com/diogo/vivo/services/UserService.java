package com.diogo.vivo.services;

import com.diogo.vivo.dto.UserDto;
import com.diogo.vivo.models.UserModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    List<UserDto> getAllUsers();

    UserDto getByEmail(String email);

    UserModel insert(UserDto userDto);
}
