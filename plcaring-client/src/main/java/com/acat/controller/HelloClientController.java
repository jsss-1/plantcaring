package com.acat.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HelloClientController {
    //接口：http://localhost:8016/helloClient
    @RequestMapping( "/helloClient")
    public String helloClient(){
        //调用业务，接收前端的参数
        return "helloClient";
    }
}