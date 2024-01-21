package com.example.exception.exception;

import com.example.exception.model.Api;
import java.util.NoSuchElementException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
//@RestControllerAdvice(basePackages = "com.example.exception.controller") // 특정 패키지의 예외만 처리하도록 설정할 수 있다.
//@RestControllerAdvice(basePackageClasses = {RestApiBController.class}) // 특정 클래스의 예외만 처리하도록 설정할 수 있다.
@Order(1) // 글로벌 예외 핸들러보다 더 우선적으로 예외 처리
public class RestApiExceptionHandler {

    /*@ExceptionHandler(value = {Exception.class})
    public ResponseEntity exception(Exception e) {
        log.error("RestApiExceptionHandler", e);

        return ResponseEntity.status(200).build();
    }*/



    @ExceptionHandler(value = {IndexOutOfBoundsException.class})
    public ResponseEntity outOfBound(IndexOutOfBoundsException e) {
        log.error("인덱스 에러만 잡는 메소드");

        return ResponseEntity.status(200).build();
    }


    // NoSuchElement 예외가 발생했을 때 Api 클래스 형식으로 바디 내려주기.
    @ExceptionHandler(value = {NoSuchElementException.class})
    public ResponseEntity<Api> noSuchElement(NoSuchElementException e) {
        log.error("No Such Element 에러 발생", e);

        var response = Api.builder()
                .resultCode(String.valueOf(HttpStatus.NOT_FOUND.value()))
                .resultMessage(HttpStatus.NOT_FOUND.getReasonPhrase())
                .build();

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(response);
    }
}

