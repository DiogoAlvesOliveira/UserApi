package com.diogo.vivo.controllers;

import com.diogo.vivo.dto.UserDto;
import com.diogo.vivo.models.UserModel;
import com.diogo.vivo.services.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    void getAllUsersTest() throws Exception {
        List<UserDto> userDtos = new ArrayList<>();
        userDtos.add(new UserDto());

        Mockito.when(userService.getAllUsers()).thenReturn(userDtos);
        this.mockMvc.perform(get("/users"))
                .andExpect(status().isOk());
    }

    @Test
    void getByEmailTest() throws Exception {
        UserModel user = new UserModel("Diogo", "diogo@gmail.com", "1234");
        UserDto dto = new UserDto(user);

        Mockito.when(userService.getByEmail(user.getEmail())).thenReturn(dto);
        this.mockMvc.perform(get("/users/{email}", user.getEmail())).andExpect(status().isOk());
    }

    @Test
    void insertUserTest() throws Exception {
        UserModel user = new UserModel("Miguel", "miguel@gmail.com", "1234");

        Mockito.when(userService.insert(Mockito.any())).thenReturn(user);
        mockMvc.perform(post("/users")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(new UserDto(user))))
                .andExpect(status().isCreated());
    }

    @Test
    void updateUserTest() throws Exception {
        UserModel user = new UserModel("Diogo", "diogo@gmail.com", "1234");
        UserDto userDto = new UserDto(user);

        Mockito.doNothing().when(userService).updateUser(user.getEmail(), userDto);

        mockMvc.perform(put("/users/{email}", user.getEmail())
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(userDto)))
                .andExpect(status().isNoContent());
    }
}
