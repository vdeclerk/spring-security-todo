package com.v15k.todo.exception;

public class EntityDoesNotExistException extends RuntimeException {
  public EntityDoesNotExistException(String message) {
    super(message);
  }
}
