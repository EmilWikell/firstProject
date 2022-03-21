package com.example.firstproject;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController{

    @RequestMapping("/")
    public String index(){
        return "Hello World";
    }

    @RequestMapping("/esp")
    public String esp(){
        return "Hola Mundo";
    }
}
