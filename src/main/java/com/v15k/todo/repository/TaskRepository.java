package com.v15k.todo.repository;

import com.v15k.todo.domain.Task;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Integer> {

  List<Task> findAllByOrderByExpiryDate();

  List<Task> findByExpiryDateLessThanOrderByExpiryDate(LocalDate date);

}