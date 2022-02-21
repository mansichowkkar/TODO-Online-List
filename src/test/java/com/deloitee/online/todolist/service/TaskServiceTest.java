package com.deloitee.online.todolist.service;

import com.deloitee.online.todolist.model.Task;
import com.deloitee.online.todolist.repository.TaskRepository;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TaskServiceTest {

    @Mock
    private TaskRepository mockTaskRepository;

    @InjectMocks
    private TaskService classUnderTest;

    @Test
    public void getAllTasksByUser_retunOneTask() {
        //arrange
        String name = "user1";

        Task tasks = new Task();
        tasks.setLastUpdatedDate(Date.valueOf(LocalDate.of(12,02,22)));
        tasks.setUserEmail("user1.123@gmail.com");
        tasks.setId(1);
        tasks.setTitle("abc");
        tasks.setStatus("InProgress");
        tasks.setDescription("task created");

        List<Task> expectedTasks = new ArrayList<Task>();
        expectedTasks.add(tasks);

        when(mockTaskRepository.findByName(name))
                .thenReturn(expectedTasks);


        //Act
        List<Task> actualResult = classUnderTest.getAllTasksByUser(name);

        // assert
        assertThat(actualResult).isEqualTo(expectedTasks);
    }

    @Test
    public void getTaskById_happyPath() {

        //arrange
        int taskId = 1;

        Task tasks = new Task();
        tasks.setLastUpdatedDate(Date.valueOf(LocalDate.of(12,02,22)));
        tasks.setUserEmail("user1.123@gmail.com");
        tasks.setId(1);
        tasks.setTitle("abc");
        tasks.setStatus("InProgress");
        tasks.setDescription("task created");

        Optional<Task>  expectedTasks = null;



        when(mockTaskRepository.findById(taskId))
                .thenReturn(expectedTasks);


        //Act
        Optional<Task>  actualResult = Optional.ofNullable(classUnderTest.getTaskById(taskId));

        // assert
        assertThat(actualResult).isEqualTo(expectedTasks);
    }

}