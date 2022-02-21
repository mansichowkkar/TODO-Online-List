package com.deloitee.online.todolist.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.deloitee.online.todolist.model.Task;
import com.deloitee.online.todolist.service.TaskService;

@Controller
public class TaskController {
	
	@Autowired
	TaskService taskService;
	
	/*
	 * @GetMapping(value="/user/tasks") private String getAllTasks(Model model) {
	 * List<Task> list = taskService.getAllTasks(); model.addAttribute("tasks",
	 * list); return "user/taskList"; }
	 */
	
	@GetMapping("/user/task/{id}") 
	private Task getTask(@PathVariable("id") int taskId) {
		return taskService.getTaskById(taskId);
	}
	
	@RequestMapping(path = {"/user/edit", "/user/edit/{id}"})
	private ModelAndView editTask(Model model, @PathVariable("id") Optional<Integer> taskId) {
		ModelAndView modelAndView = new ModelAndView();
		if (taskId.isPresent()) {
            Task entity = taskService.getTaskById(taskId.get());
            modelAndView.addObject("task", entity);
        } else {
        	modelAndView.addObject("task", new Task());
        }
		modelAndView.setViewName("user/add-task");
        return modelAndView;
	}
	 
	@RequestMapping(path = "/user/createTask", method = RequestMethod.POST) 
	private String createTask(Task task) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		task.setUserEmail(auth.getName());
		taskService.saveOrUpdate(task); 
		return "redirect:/user/tasks"; 
	}
	
	@RequestMapping(path = "/user/deleteTask/{id}")
	private String deleteTask(Model model, @PathVariable("id") int taskId) {
		taskService.deleteTaskByID(taskId);
		return "redirect:/user/tasks";
	}
	
}
