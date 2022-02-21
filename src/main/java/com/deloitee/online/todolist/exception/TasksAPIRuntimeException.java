package com.deloitee.online.todolist.exception;

public class TasksAPIRuntimeException extends RuntimeException{

    public TasksAPIRuntimeException(String message) {
        super(message);
    }

    public TasksAPIRuntimeException(String message, Exception e) {
        super(message, e);
    }
}
