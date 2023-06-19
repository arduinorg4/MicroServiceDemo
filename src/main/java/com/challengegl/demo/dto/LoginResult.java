package com.challengegl.demo.dto;

import com.challengegl.demo.model.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LoginResult {
    private User user;
    private String token;

    // getters y setters
}