package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.service.ProductoService;


/**
 *
 * @author Tom
 */
@Controller
@RequestMapping("/productos") 
public class ProductoController {

    @Autowired
    private ProductoService productoService;


}

    