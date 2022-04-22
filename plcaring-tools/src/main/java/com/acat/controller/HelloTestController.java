package com.acat.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloTestController {
    @RequestMapping("/helloTest")
    public String helloTest(){
        return "helloTest";
    }
}
