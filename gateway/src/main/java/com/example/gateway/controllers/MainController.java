package com.example.gateway.controllers;

import com.example.gateway.service.HelloClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {
    @Autowired
    private HelloClientService service;

    @GetMapping("/greeting/{name}")
    @ResponseBody
    public String greeting(@PathVariable String name){
        return service.sayHello(name);
    }
}
