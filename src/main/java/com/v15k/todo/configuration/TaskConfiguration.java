package com.v15k.todo.configuration;

import com.v15k.todo.domain.Task;
import com.v15k.todo.repository.TaskRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class TaskConfiguration {

  @Bean
  CommandLineRunner commandLineRunner(TaskRepository taskRepository){
    return args -> {
              Task task1 = new Task(
                      "First thing TODO",
                      LocalDate.of(2021, 3, 19),
                      LocalDate.of(2021, 5, 6),
                      false);
              Task task2 = new Task(
                      "Second thing TODO",
                      LocalDate.of(2021, 3, 19),
                      LocalDate.of(2021, 5, 6),
                      false);


              taskRepository.saveAll(List.of(task1, task2));
    };
  }
}
