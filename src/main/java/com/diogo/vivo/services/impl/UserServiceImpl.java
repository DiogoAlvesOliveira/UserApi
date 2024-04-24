package com.diogo.vivo.services.impl;

import com.diogo.vivo.dto.UserDto;
import com.diogo.vivo.models.UserModel;
import com.diogo.vivo.repositories.UserRepository;
import com.diogo.vivo.services.UserService;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<UserDto> getAllUsers() {
        List<UserModel>users = userRepository.findAll();
        return users.stream().map(UserDto::new).toList();
    }

    @Override
    public UserDto getByEmail(String email) {
        UserModel user = userRepository.findByEmail(email);
        if (user != null) return new UserDto(user);
        throw new ObjectNotFoundException((Object) email, "Email not found");
    }

    @Override
    public UserModel insert(UserDto userDto) {
        UserModel userModel = this.fromDTO(userDto);
        userRepository.save(userModel);
        return userModel;
    }

    private UserModel fromDTO(UserDto userDto) {
        return new UserModel(userDto.getName(), userDto.getEmail(), userDto.getDocument());
    }
}
