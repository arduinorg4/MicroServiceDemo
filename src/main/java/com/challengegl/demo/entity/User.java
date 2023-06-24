package com.challengegl.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.UUID;


@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue
    private UUID id;
    @NotBlank(message = "Name is mandatory")
    private String name;

    private String email;

    @NotBlank(message = "Password is mandatory")
    //@Size(min = 1, max = 12, message = "Password must be between 8 and 12 characters")
    private String password;
    private boolean isActive;
    private String token;
    private String created;
    private String lastLogin;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Phone> phones;
}
