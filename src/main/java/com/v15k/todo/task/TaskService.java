package com.v15k.todo.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

  private final TaskRepository taskRepository;

  @Autowired
  public TaskService(TaskRepository taskRepository) {
    this.taskRepository = taskRepository;
  }

  public List<Task> getTasks() {
    return taskRepository.findAll();
  }

  public void addTask(Task task) {
    taskRepository.save(task);
  }

  public void deleteTask(Integer id) {
    boolean exist = taskRepository.existsById(id);
    if(!exist)
      throw new IllegalStateException("Task with id " + id + "does not exist");

    taskRepository.deleteById(id);
  }

  @Transactional
  public void completeTask(Integer id) {
    boolean exist = taskRepository.existsById(id);
    if(!exist)
      throw new IllegalStateException("Task with id " + id + "does not exist");
    Task task = taskRepository.findById(id).get();
    task.setDone(true);
    taskRepository.save(task);
  }
}
