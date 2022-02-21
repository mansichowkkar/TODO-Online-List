package com.deloitee.online.todolist.service;

import com.deloitee.online.todolist.model.User;

public interface UserService {

    public User findUserByEmail(String email) ;
    public User saveUser(User user);
}
