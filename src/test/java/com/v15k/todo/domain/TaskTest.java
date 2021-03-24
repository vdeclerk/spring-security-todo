package com.v15k.todo.domain;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class TaskTest {

  @Test
  void getProgress() {
    Task task = new Task("Title", "Description",
            LocalDate.now().minusDays(3), LocalDate.now().plusDays(3), false);
    assertEquals(50, task.getProgress());
  }
  @Test
  void getProgressOfANewTask() {
    // A new task has 0% progress
    Task task = new Task("Title", "Description",
            LocalDate.now(), LocalDate.now().plusDays(3), false);
    assertEquals(0, task.getProgress());
    // Another new task with 0% progress
    task = new Task("Title", "Description",
            LocalDate.now(), LocalDate.now().plusDays(30), false);
    assertEquals(0, task.getProgress());
  }
  @Test
  void getProgressOfFutureTask() {
    // A task created in the future has 0% progress
    Task task = new Task("Title", "Description",
            LocalDate.now().plusDays(3), LocalDate.now().plusDays(3), false);
    assertEquals(0, task.getProgress());
  }
  @Test
  void getProgressOfExpiredTask() {
    // A task with expiry date in the past has 100% progress
    Task task = new Task("Title", "Description",
            LocalDate.now().minusDays(6), LocalDate.now().minusDays(3), false);
    assertEquals(100, task.getProgress());
  }
  @Test
  void getProgressOfTask() {
    // A task of 30 days which has 3 days old has 10% progress
    Task task = new Task("Title", "Description",
            LocalDate.now().minusDays(3), LocalDate.now().plusDays(27), false);
    assertEquals(10, task.getProgress());
  }
}