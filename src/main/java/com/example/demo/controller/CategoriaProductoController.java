package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.service.CategoriaProductoService;


/**
 *
 * @author Tom
 */
@Controller
@RequestMapping("/categorias-producto") 
public class CategoriaProductoController {

    @Autowired
    private CategoriaProductoService categoriaProductoService;
}
    