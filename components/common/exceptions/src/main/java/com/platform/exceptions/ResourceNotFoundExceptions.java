package com.platform.exceptions;

public abstract class ResourceNotFoundExceptions extends RuntimeException{
    public ResourceNotFoundExceptions(String errorMessage){
        super(errorMessage);
    }
}
