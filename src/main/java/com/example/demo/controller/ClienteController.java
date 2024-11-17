package com.example.demo.controller;

import com.example.demo.domain.Cliente;
import com.example.demo.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 *
 * @author jeffer
 */
@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public List<Cliente> getAllClientes() {
        return clienteService.getClientes();
    }

    @GetMapping("/{id}")
    public Cliente getClienteById(@PathVariable Long id) {
        Cliente cliente = new Cliente();
        cliente.setId(id);
        return clienteService.getCliente(cliente);
    }

    @PostMapping
    public void saveCliente(@RequestBody Cliente cliente) {
        clienteService.save(cliente);
    }

    @DeleteMapping("/{id}")
    public void deleteCliente(@PathVariable Long id) {
        Cliente cliente = new Cliente();
        cliente.setId(id);
        clienteService.delete(cliente);
    }
}