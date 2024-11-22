package com.example.demo.controller;

import com.example.demo.domain.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import com.example.demo.service.ClienteService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author jeffer
 */
@Controller
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

//    @GetMapping("/listado")
//    public String listado(Model model) {
//        var clientes = clienteService.getClientes();
//        int cantidad_clientes = clienteService.getClientesSize();
//        model.addAttribute("clientes", clientes);
//        model.addAttribute("totalClientes", clientes.size());
//        return "cliente/listado";
//    }
    
        @GetMapping("/listado")
    public String listado(Model model) {
        var clientes = clienteService.getClientes();
        model.addAttribute("clientes", clientes);
        model.addAttribute("totalClientes", clientes.size());

        return "/cliente/listado";
    }

    @PostMapping("/guardar")
    public String clienteGuardar(Cliente cliente) {
        clienteService.save(cliente);
        return "redirect:/cliente/listado";
    }

    @GetMapping("/eliminar/{clienteId}")
    public String clienteEliminar(Cliente cliente) {
        clienteService.delete(cliente);
        return "redirect:/cliente/listado";
    }

    @GetMapping("/modificar/{clienteId}")
    public String clienteModificar(Cliente cliente, Model model) {
        cliente = clienteService.getCliente(cliente);
        model.addAttribute("cliente", cliente);
        return "/cliente/modifica";
    }

    @PostMapping("/update")
    public String clienteUpdate(Cliente cliente) {
        clienteService.update(cliente);
        return "redirect:/cliente/listado";
    }

//    @GetMapping("/cliente/{clienteId}")
//    public String clienteEliminar(Cliente cliente) {
//        clienteService.delete(cliente);
//        return "redirect:/cliente/listado";
//    }
        @GetMapping("/nuevo")
    public String clienteNuevo(Cliente cliente){
        return "/cliente/modifica";
    }
    
  
    
 
    

     
}
