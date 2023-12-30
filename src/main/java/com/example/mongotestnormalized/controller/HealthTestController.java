package com.example.mongotestnormalized.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthTestController {
    @GetMapping("/success")
    public String checkHealth() {
        return "success";
    }
}
