package com.example.exception.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/b")
public class RestApiBController {

    // http://localhost:8080/api/b/hello
    @GetMapping(path = "/hello")
    public void hello() {
        throw new NumberFormatException("number format exception 발생");
    }


    // 컨트롤러에서도 특정 예외를 따로 처리할 수 있음. (이 방법은 추천하지 않음 -> Global Exception Handler에서 예외 처리하는 것이 좋음)
    /*@ExceptionHandler(value = {NumberFormatException.class})
    public ResponseEntity numberFormatException(NumberFormatException e) {
        log.error("RestApiBController에서 발생", e);

        return ResponseEntity.status(200).build();
    }*/
}
