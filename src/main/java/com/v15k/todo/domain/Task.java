package com.v15k.todo.domain;

import javax.persistence.*;
import java.time.LocalDate;

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
  private Integer id;
  private String description;
  private LocalDate creationDate;
  private LocalDate expireDate;
  private boolean done;

  public Task(){}

  public Task(Integer id, String description, LocalDate creationDate, LocalDate expireDate, boolean done) {
    this.id = id;
    this.description = description;
    this.creationDate = creationDate;
    this.expireDate = expireDate;
    this.done = done;
  }

  public Task(String description, LocalDate creationDate, LocalDate expireDate, boolean done) {
    this.description = description;
    this.creationDate = creationDate;
    this.expireDate = expireDate;
    this.done = done;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getDescription() {
    return description;
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

  public LocalDate getExpireDate() {
    return expireDate;
  }

  public void setExpireDate(LocalDate expireDate) {
    this.expireDate = expireDate;
  }

  public boolean isDone() {
    return done;
  }

  public void setDone(boolean done) {
    this.done = done;
  }

  @Override
  public String toString() {
    return "Task{" +
            "id=" + id +
            ", description='" + description + '\'' +
            ", creationDate=" + creationDate +
            ", expireDate=" + expireDate +
            ", done=" + done +
            '}';
  }
}
