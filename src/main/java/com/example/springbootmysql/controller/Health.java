package com.example.springbootmysql.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

public class Health {
    public String getHealth() {
        return "OK";
    }
}
