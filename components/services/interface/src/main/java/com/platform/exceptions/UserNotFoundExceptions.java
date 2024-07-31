package com.platform.exceptions;

public class UserNotFoundExceptions extends ResourceNotFoundExceptions{
    public UserNotFoundExceptions(String errorMessage) {
        super(errorMessage);
    }
}
