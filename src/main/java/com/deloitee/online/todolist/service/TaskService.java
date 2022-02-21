package com.deloitee.online.todolist.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.deloitee.online.todolist.exception.TasksAPIRuntimeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deloitee.online.todolist.model.Task;
import com.deloitee.online.todolist.repository.TaskRepository;

import static java.lang.String.format;

@Service
public class TaskService {

	@Autowired
	TaskRepository taskRepository;

	public List<Task> getAllTasksByUser(String name) {
		List<Task> tasks = new ArrayList<Task>();  
		taskRepository.findByName(name).forEach(task -> tasks.add(task));
		try{
			return tasks;
		}catch (Exception e) {
			throw new TasksAPIRuntimeException("Error finding tasks from user name.", e);
		}

	}
	
	public Task getTaskById(int taskId) {
		Optional<Task> task = taskRepository.findById(taskId);
		return task.orElseGet(() -> {
			throw new TasksAPIRuntimeException(
					format("Failed to find tasks for task id %d", taskId)
			);
		});
	}
	
	public void saveOrUpdate(Task task)   
	{  
		LocalDate today = LocalDate.now();
		task.setLastUpdatedDate( java. sql. Date. valueOf(today));
		taskRepository.save(task);  
	} 
	
	public void deleteTaskByID(int id) {
		taskRepository.deleteById(id);
	}
}
