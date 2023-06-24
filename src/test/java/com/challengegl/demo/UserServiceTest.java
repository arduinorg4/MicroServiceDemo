package com.challengegl.demo;

import com.challengegl.demo.dto.UserResponseDTO;
import com.challengegl.demo.entity.User;
import com.challengegl.demo.repository.UserRepository;
import com.challengegl.demo.service.UserService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.Mockito.*;

@SpringBootTest
public class UserServiceTest {

    @InjectMocks
    private UserService userService;

    @Mock
    private UserRepository userRepository;

    @Test
    public void testCreateUser2() {
        User user = new User();
        user.setName("Test User");
        user.setEmail("test@example.com");
        user.setPassword("password");

        UserRepository mockUserRepository = mock(UserRepository.class);
        when(mockUserRepository.save(user)).thenReturn(user);

        UserService mockUserService = mock(UserService.class);
        when(mockUserService.createUser(user)).thenReturn(new UserResponseDTO());

        UserResponseDTO result = mockUserService.createUser(user);

        verify(mockUserService, times(1)).createUser(user);
    }

}
