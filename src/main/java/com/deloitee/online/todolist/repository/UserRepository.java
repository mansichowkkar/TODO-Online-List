package com.deloitee.online.todolist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.deloitee.online.todolist.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    public User findByEmail(
            @Param("email")String email
    );
}
