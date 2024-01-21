package com.example.exception.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j

@RestControllerAdvice(basePackages = "com.example.exception.controller") // 특정 패키지의 예외만 처리하도록 설정할 수 있다.
//@RestControllerAdvice(basePackageClasses = {RestApiBController.class}) // 특정 클래스의 예외만 처리하도록 설정할 수 있다.
public class RestApiExceptionHandler {

    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity exception(Exception e) {
        log.error("RestApiExceptionHandler", e);

        return ResponseEntity.status(200).build();
    }


    @ExceptionHandler(value = {IndexOutOfBoundsException.class})
    public ResponseEntity outOfBound(IndexOutOfBoundsException e) {
        log.error("인덱스 에러만 잡는 메소드");

        return ResponseEntity.status(200).build();
    }
}

