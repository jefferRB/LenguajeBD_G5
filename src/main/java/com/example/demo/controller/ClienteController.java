package com.example.demo.controller;

import com.example.demo.domain.Cliente;
import com.example.demo.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 *
 * @author jeffer
 */
@Controller
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping("/listado")
    public String listado(Model model) {
        var lista = clienteService.getClientes();
        model.addAttribute("clientes", lista);
        model.addAttribute("totalClientes", lista.size());
        return "/cliente/listado";
    }

    @PostMapping("/guardar")
    public String save(Cliente cliente) {
        clienteService.save(cliente);
        return "redirect:/cliente/listado";
    }

    @GetMapping("/modifica/{clienteId}")
    public String modifica(@PathVariable("clienteId") Long clienteId, Model model) {
        Cliente cliente = clienteService.getCliente(new Cliente(clienteId));
        model.addAttribute("cliente", cliente);
        return "/cliente/modifica";
    }

    @GetMapping("/eliminar/{clienteId}")
    public String elimina(@PathVariable("clienteId") Long clienteId) {
        clienteService.delete(new Cliente(clienteId));
        return "redirect:/cliente/listado";
    }
}
