package com.v15k.todo.domain;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;

@Entity
@Table
public class Task {
  @Id
  @SequenceGenerator(
          name = "task_sequence",
          sequenceName = "task_sequence",
          allocationSize = 1
  )
  @GeneratedValue(
          strategy = GenerationType.SEQUENCE,
          generator = "task_sequence"
  )
  private Integer taskId;
  private String title;
  private String description;
  private LocalDate creationDate;
  private LocalDate expiryDate;
  private boolean done;
  @Transient
  private Integer progress;

  public Task(){}

  public Task(Integer taskId, String title, String description, LocalDate creationDate, LocalDate expiryDate, boolean done) {
    this.taskId = taskId;
    this.title = title;
    this.description = description;
    this.creationDate = creationDate;
    this.expiryDate = expiryDate;
    this.done = done;
  }

  public Task(String title, String description, LocalDate creationDate, LocalDate expiryDate, boolean done) {
    this.title = title;
    this.description = description;
    this.creationDate = creationDate;
    this.expiryDate = expiryDate;
    this.done = done;
  }

  public Integer getTaskId() {
    return taskId;
  }

  public void setTaskId(Integer taskId) {
    this.taskId = taskId;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getDescription() {
    return
            description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public LocalDate getCreationDate() {
    return creationDate;
  }

  public void setCreationDate(LocalDate creationDate) {
    this.creationDate = creationDate;
  }

  public LocalDate getExpiryDate() {
    return expiryDate;
  }

  public void setExpiryDate(LocalDate expiryDate) {
    this.expiryDate = expiryDate;
  }

  public boolean isDone() {
    return done;
  }

  public void setDone(boolean done) {
    this.done = done;
  }

  public Integer getProgress() {
    if(done) return 100;
    if(creationDate.isAfter(LocalDate.now())) return 0;
    if(expiryDate.isBefore(LocalDate.now())) return 100;
    return Period.between(LocalDate.now(), creationDate).getDays() * 100 /
            Period.between(expiryDate, creationDate).getDays();
  }

  @Override
  public String toString() {
    return "Task{" +
            "taskId=" + taskId +
            ", title='" + title + '\'' +
            ", description='" + description + '\'' +
            ", creationDate=" + creationDate +
            ", expireDate=" + expiryDate +
            ", done=" + done +
            '}';
  }
}
