package com.platform.exceptions;

public class UserBadRequestException extends BadRequestException{
    public UserBadRequestException(String errorMessage) {
        super(errorMessage);
    }
}
