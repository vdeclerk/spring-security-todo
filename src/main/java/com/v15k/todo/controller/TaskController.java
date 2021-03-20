package com.v15k.todo.controller;

import com.v15k.todo.domain.Task;
import com.v15k.todo.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="api/v1/task")
public class TaskController {

  private final TaskService taskService;

  @Autowired
  public TaskController(TaskService taskService) {
    this.taskService = taskService;
  }

  @GetMapping
  public List<Task> hello() {
    return taskService.getTasks();
  }

  @PostMapping
  public void registerTask(@RequestBody Task task) {
    taskService.addTask(task);
  }

  @DeleteMapping(path="{taskId}")
  public void deleteTask(@PathVariable("taskId") Integer id) {
    taskService.deleteTask(id);
  }

  @PutMapping(path="{taskId}")
  public void completeTask(@PathVariable("taskId") Integer id) {
    taskService.completeTask(id);
  }
}


