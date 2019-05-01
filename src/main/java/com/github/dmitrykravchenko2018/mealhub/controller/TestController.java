package com.github.dmitrykravchenko2018.mealhub.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class TestController {

    @RequestMapping(method = RequestMethod.GET, value = "/hello", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<String> hello() {
        return ResponseEntity.ok("Hello");
    }
}
