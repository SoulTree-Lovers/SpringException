package com.example.exception.controller;

import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api")
public class RestApiController {

    @GetMapping(path = "")
    public void hello() {
        var list = List.of("hello");
        var element = list.get(1); // 인덱스 에러
        log.info("element : {}", element);
//        throw new RuntimeException("런타임 에러 발생");
    }
}
