package com.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.proyecto.service.ClienteService;

/**
 *
 * @author jeffer
 */
@Controller
@RequestMapping("/clientes") 
public class ClienteController {

    @Autowired
    private ClienteService clienteService;


}

    