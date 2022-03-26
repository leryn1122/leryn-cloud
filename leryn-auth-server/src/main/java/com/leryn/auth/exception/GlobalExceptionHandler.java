package com.leryn.auth.exception;

import javax.validation.ConstraintViolationException;

import com.leryn.common.vo.Result;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author Leryn
 * @since Leryn 1.0.0
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public Result methodArgumentNotValidException(MethodArgumentNotValidException e) {
    e.printStackTrace();
    return Result.onError(e.getBindingResult().getAllErrors().get(0).getDefaultMessage());
  }

  @ExceptionHandler(ConstraintViolationException.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public Result constraintViolationException(ConstraintViolationException e) {
    e.printStackTrace();
    return Result.onError(e.getMessage());
  }

  @ExceptionHandler(Exception.class)
  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
  public Result exception(Exception e) {
    e.printStackTrace();
    return Result.onError(e.getMessage());
  }

}
