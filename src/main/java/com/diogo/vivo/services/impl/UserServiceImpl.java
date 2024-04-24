package com.diogo.vivo.services.impl;

import com.diogo.vivo.dto.UserDto;
import com.diogo.vivo.models.UserModel;
import com.diogo.vivo.repositories.UserRepository;
import com.diogo.vivo.services.UserService;
import org.apache.catalina.util.StringUtil;
import org.apache.logging.log4j.util.Strings;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

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

    @Override
    public void updateUser(String email, UserDto userDto) {
        UserModel userModel = userRepository.findByEmail(email);
        if (userModel != null) {
            this.updateData(userModel, userDto);
            userRepository.save(userModel);
        } else {
            throw new ObjectNotFoundException((Object) email, "Email not found");
        }
    }

    private void updateData(UserModel userModel, UserDto userDto) {
        if (Strings.isNotEmpty(userDto.getName())) userModel.setName(userDto.getName());
        if (Strings.isNotEmpty(userDto.getEmail())) userModel.setEmail(userDto.getEmail());
        if (Strings.isNotEmpty(userDto.getDocument())) userModel.setDocument(userDto.getDocument());
    }

    private UserModel fromDTO(UserDto userDto) {
        return new UserModel(userDto.getName(), userDto.getEmail(), userDto.getDocument());
    }
}
