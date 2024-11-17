package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.service.PedidoService;


/**
 *
 * @author Tom
 */
@Controller
@RequestMapping("/pedidos") 
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;


}

    