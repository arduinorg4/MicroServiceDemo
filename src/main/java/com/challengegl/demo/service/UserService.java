package com.challengegl.demo.service;

import com.challengegl.demo.dto.LoginResult;
import com.challengegl.demo.dto.PhoneDTO;
import com.challengegl.demo.dto.UserResponseDTO;
import com.challengegl.demo.entity.Phone;
import com.challengegl.demo.entity.User;
import com.challengegl.demo.repository.UserRepository;
import com.challengegl.demo.service.exceptions.InvalidCredentialsException;
import com.challengegl.demo.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final JwtUtil jwtUtil;
    private final BCryptPasswordEncoder passwordEncoder;


    public UserResponseDTO createUser(User user) {
        user.setCreated(LocalDate.now().toString());
        user.setLastLogin(LocalDate.now().toString());
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setToken(jwtUtil.generateToken(user.getEmail()));
        User savedUser = userRepository.saveAndFlush(user);
        return convertToDTO(savedUser);
    }

    private UserResponseDTO convertToDTO(User user) {
        UserResponseDTO dto = new UserResponseDTO();
        dto.setId(user.getId());
        dto.setCreated(user.getCreated());
        dto.setLastLogin(user.getLastLogin());
        dto.setToken(user.getToken());
        dto.setActive(user.isActive());
        return dto;
    }

    private PhoneDTO convertPhoneToDTO(Phone phone) {
        PhoneDTO dto = new PhoneDTO();
        dto.setId(phone.getId());
        dto.setNumber(phone.getNumber());
        dto.setCitycode(phone.getCitycode());
        dto.setContrycode(phone.getContrycode());
        return dto;
    }


    public LoginResult loginUser(User user) throws InvalidCredentialsException {
        User existingUser = userRepository.findByName(user.getName());
        if (existingUser != null && passwordEncoder.matches(user.getPassword(), existingUser.getPassword())) {
            String token = jwtUtil.generateToken(existingUser.getEmail());
            LoginResult result = new LoginResult();
            result.setUser(existingUser);
            result.setToken(token);
            return result;
        } else {
            throw new InvalidCredentialsException("Invalid email or password");
        }
    }
}
