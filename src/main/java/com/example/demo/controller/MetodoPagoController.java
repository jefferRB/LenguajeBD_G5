package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.service.MetodoPagoService;


/**
 *
 * @author Tom
 */
@Controller
@RequestMapping("/metodos-pago") 
public class MetodoPagoController {

    @Autowired
    private MetodoPagoService metodoPagoService;
}