package com.deloitee.online.todolist.service;

import com.deloitee.online.todolist.exception.UserNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.deloitee.online.todolist.model.Role;
import com.deloitee.online.todolist.model.User;
import com.deloitee.online.todolist.repository.RoleRepository;
import com.deloitee.online.todolist.repository.UserRepository;

import java.util.Arrays;
import java.util.HashSet;

import static java.lang.String.format;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public UserServiceImpl(
            UserRepository userRepository,
            RoleRepository roleRepository,
            BCryptPasswordEncoder bCryptPasswordEncoder
    ) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public User findUserByEmail(String email) {
        log.debug( "findUserByEmail invoked with email", email);
        try{
            return userRepository.findByEmail(email);
        }catch (Exception e) {
            throw new UserNotFoundException("Error finding user.", e);
        }

    }

    @Override
    public User saveUser(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setActive(1);
        Role userRole = roleRepository.findByRole("USER");
        user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));

        return userRepository.save(user);
    }
}
