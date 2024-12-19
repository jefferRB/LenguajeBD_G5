package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


/**
 *
 * @author Tom
 */
@Controller
public class Principal {

    @GetMapping("/")
    public String index() {
        return "Base"; // Asegúrate de que esto coincida con el nombre del archivo Base.html
    }
}