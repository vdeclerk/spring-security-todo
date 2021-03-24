package com.v15k.todo.service;

import com.v15k.todo.domain.Task;
import com.v15k.todo.exception.EntityDoesNotExistException;
import com.v15k.todo.repository.TaskRepository;
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
    return taskRepository.findAllByOrderByExpiryDate();
  }

  public  List<Task> getNextWeekTasks() {
    return taskRepository.findByExpiryDateLessThanOrderByExpiryDate(LocalDate.now().plusDays(7));
  }

  public  List<Task> getNextMonthTasks() {
    return taskRepository.findByExpiryDateLessThanOrderByExpiryDate(LocalDate.now().plusDays(30));
  }

  public void addTask(Task task) {
    taskRepository.save(task);
  }

  @Transactional
  public void deleteTask(Integer id) {
    boolean exist = taskRepository.existsById(id);
    if(!exist)
      throw new EntityDoesNotExistException("Task with id " + id + "does not exist");
    taskRepository.deleteById(id);
  }

  @Transactional
  public void saveTask(Task task) {
    boolean exist = taskRepository.existsById(task.getTaskId());
    if(!exist)
      throw new EntityDoesNotExistException("Task with id " + task.getTaskId() + " does not exist.");
    taskRepository.save(task);
  }
}
