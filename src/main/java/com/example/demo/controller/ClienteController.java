package com.example.demo.controller;

import com.example.demo.domain.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
<<<<<<< Updated upstream
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import com.example.demo.service.ClienteService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
=======
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;


>>>>>>> Stashed changes

/**
 *
 * @author jeffer
 */
@Controller
<<<<<<< Updated upstream
@RequestMapping("/clientes")
=======
@RequestMapping("/cliente")
>>>>>>> Stashed changes
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

<<<<<<< Updated upstream
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

=======
    @GetMapping("/listado")
    public String listado(Model model) {
        var lista = clienteService.getClientes();
        model.addAttribute("clientes", lista);
        model.addAttribute("totalClientes", lista.size());
>>>>>>> Stashed changes
        return "/cliente/listado";
    }

    @PostMapping("/guardar")
<<<<<<< Updated upstream
    public String clienteGuardar(Cliente cliente) {
=======
    public String save(Cliente cliente) {
>>>>>>> Stashed changes
        clienteService.save(cliente);
        return "redirect:/cliente/listado";
    }

<<<<<<< Updated upstream
    @GetMapping("/eliminar/{clienteId}")
    public String clienteEliminar(Cliente cliente) {
        clienteService.delete(cliente);
=======
    @GetMapping("/modifica/{clienteId}")
    public String modifica(@PathVariable("clienteId") Long clienteId, Model model) {
        Cliente cliente = clienteService.getCliente(new Cliente(clienteId));
        model.addAttribute("cliente", cliente);
        return "/cliente/modifica";
    }

    @GetMapping("/eliminar/{clienteId}")
    public String elimina(@PathVariable("clienteId") Long clienteId) {
        clienteService.delete(new Cliente(clienteId));
>>>>>>> Stashed changes
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
