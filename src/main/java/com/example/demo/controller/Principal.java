package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


/**
 *
 * @author Tom
 */
@Controller
public class Principal {

    @GetMapping("/")
    public String index() {
        return "Templates/Base"; 
    }
}