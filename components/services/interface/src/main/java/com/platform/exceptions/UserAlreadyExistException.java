package com.platform.exceptions;

public class UserAlreadyExistException extends ResourceAlreadyExistsException {
    public UserAlreadyExistException(String errorMessage) {
        super(errorMessage);
    }
}
