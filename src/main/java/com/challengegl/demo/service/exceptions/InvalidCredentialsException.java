package com.challengegl.demo.service.exceptions;

public class InvalidCredentialsException extends Throwable {
    public InvalidCredentialsException(String invalidEmailOrPassword) {
        throw new RuntimeException(invalidEmailOrPassword);
    }
}
