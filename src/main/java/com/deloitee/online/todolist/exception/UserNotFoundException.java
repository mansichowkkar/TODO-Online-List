package com.deloitee.online.todolist.exception;

public class UserNotFoundException extends TasksAPIRuntimeException{

    public UserNotFoundException(String message) {
        super(message);
    }

    public UserNotFoundException(String message, Exception e) {
        super(message, e);
    }
}
