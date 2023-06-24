package com.challengegl.demo.controller;

import com.challengegl.demo.dto.LoginResponse;
import com.challengegl.demo.dto.LoginResult;
import com.challengegl.demo.dto.UserResponseDTO;
import com.challengegl.demo.entity.User;
import com.challengegl.demo.service.UserService;
import com.challengegl.demo.service.exceptions.ErrorResponse;
import com.challengegl.demo.service.exceptions.InvalidCredentialsException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/sign-up")
    public ResponseEntity<UserResponseDTO> signUp(@Valid @RequestBody User user) {
        UserResponseDTO createdUser = userService.createUser(user);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@Valid @RequestBody User user) throws InvalidCredentialsException {
        LoginResult loginResult = userService.loginUser(user);
        LoginResponse response = new LoginResponse();
        response.setUser(loginResult.getUser());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ErrorResponse> handleInvalidCredentialsException(RuntimeException ex) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setMessage("Invalid email or password");
        errorResponse.setStatus(HttpStatus.UNAUTHORIZED.value());

        return new ResponseEntity<>(errorResponse, HttpStatus.UNAUTHORIZED);
    }
}
