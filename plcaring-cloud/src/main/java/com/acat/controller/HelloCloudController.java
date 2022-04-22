package com.acat.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloCloudController {
    @RequestMapping("/helloCloud")
    public String hello(){
        return "helloCloud";
    }
}
