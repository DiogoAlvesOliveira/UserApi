package com.diogo.vivo.services.impl;

import com.diogo.vivo.models.UserModel;
import com.diogo.vivo.repositories.UserRepository;
import com.diogo.vivo.services.DbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class DbServiceImpl implements DbService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void instantiateTestDatabase() {

        UserModel user1 = new UserModel("Diogo", "diogo@gmail.com", "1234");
        UserModel user2 = new UserModel("Thiago", "thiago@gmail.com", "1234");
        UserModel user3 = new UserModel("Gustavo", "gustavo@gmail.com", "1234");
        UserModel user4 = new UserModel("Paty", "paty@gmail.com", "1234");
        UserModel user5 = new UserModel("Luna", "luna@gmail.com", "1234");

        userRepository.saveAll(Arrays.asList(user1, user2, user3, user4, user5));
    }
}
