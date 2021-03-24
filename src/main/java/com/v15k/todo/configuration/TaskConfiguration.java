package com.v15k.todo.configuration;

import com.v15k.todo.domain.Task;
import com.v15k.todo.repository.TaskRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class TaskConfiguration {

  @Bean
  CommandLineRunner commandLineRunner(TaskRepository taskRepository){
    String[] titles = {"Test something", "Build something", "Deploy something", "Refactor something"};
    String[] descriptions = {"Testing code is important. Requirements can be represented as tests.",
                             "Always must have a \"Build success\" at the end.",
                             "Software destiny is to be used, ergo must be deployed.",
                             "When everything is working you must make code look better and cleaner."};
    return args -> {
              List<Task> tasks = new ArrayList<Task>();
              for(int k = -12; k < 68; k++) {
                Task task = new Task(
                        titles[(k+12)%4],
                        descriptions[(k+12)%4],
                        LocalDate.now().plusDays(k),
                        LocalDate.now().plusDays(k+10),
                        false
                );
                tasks.add(task);
              }
              taskRepository.saveAll(tasks);
    };
  }
}
