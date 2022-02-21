package com.deloitee.online.todolist.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.deloitee.online.todolist.model.Task;
import org.springframework.data.repository.query.Param;

public interface TaskRepository extends JpaRepository<Task, Integer> {

	@Query("SELECT T FROM TASK T WHERE T.userEmail = ?1")
    List<Task> findByName(
            @Param("userEmail")String userEmail
    );
	
}
