package com.diogo.vivo.services;

import com.diogo.vivo.dto.UserDto;
import com.diogo.vivo.models.UserModel;
import com.diogo.vivo.repositories.UserRepository;
import com.diogo.vivo.services.impl.UserServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class UserServiceTest {

    @Autowired
    UserService userService;

    @MockBean
    UserRepository userRepository;

    @Test
    void getAllUsersTests() throws Exception {
        List<UserModel> users = new ArrayList<>();
        users.add(new UserModel("Diogo", "diogo@gmail.com", "1234"));

        Mockito.when(userRepository.findAll()).thenReturn(users);

        List<UserDto> userDtos = userService.getAllUsers();

        Assertions.assertEquals(1, userDtos.size());
    }

    @Test
    void getByEmailTest() throws Exception {
        String email = "diogo@gmail.com";
        UserModel user = new UserModel("Diogo", "diogo@gmail.com", "1234");

        Mockito.when(userRepository.findByEmail(email)).thenReturn(user);
        UserDto userDto = userService.getByEmail(user.getEmail());

        Assertions.assertEquals(email,userDto.getEmail());
    }

    @Test
    void insertTest() throws Exception {
        UserModel user = new UserModel("Diogo", "diogo@gmail.com", "1234");
        UserDto dto = new UserDto(user);

        userService.insert(dto);

        Mockito.verify(userRepository, Mockito.times(1)).save(ArgumentMatchers.any(UserModel.class));
    }

    @Test
    void updateUserTest() throws Exception {
        String email = "diogo@gmail.com";
        UserModel user = new UserModel("Diogo", "diogo@gmail.com", "1234");
        UserDto dto = new UserDto("Miguel", "miguel@gmail.com", "1234");

        Mockito.when(userRepository.findByEmail(email)).thenReturn(user);

        userService.updateUser(email, dto);

        Mockito.verify(userRepository, Mockito.times(1)).save(ArgumentMatchers.any(UserModel.class));
    }
}
