package com.platform.exceptions;

public class UserApiException extends ApiException{
    public UserApiException(String errorMessage) {
        super(errorMessage);
    }
}
