package com.challengegl.demo;

import com.challengegl.demo.dto.UserResponseDTO;
import com.challengegl.demo.model.User;
import com.challengegl.demo.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.UUID;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @Test
    public void testSignUp() throws Exception {
        UserResponseDTO user = new UserResponseDTO();
        user.setId(UUID.randomUUID());
        user.setToken("asdfasdf");

        when(userService.createUser(any(User.class))).thenReturn(user);

        mockMvc.perform(post("/api/sign-up")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"name\":\"test user\", \"email\":\"test@example.com\",\"password\":\"password\"}"))
                .andExpect(status().isCreated());

        verify(userService, times(1)).createUser(any(User.class));
    }
}
