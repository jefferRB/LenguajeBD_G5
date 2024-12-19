package com.example.demo.controller;

import com.example.demo.domain.Cliente;
import com.example.demo.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public String listClientes(Model model) {
        List<Cliente> clientes = clienteService.getClientes();
        model.addAttribute("clientes", clientes);
        model.addAttribute("cliente", new Cliente());
        return "clientes"; 
    }

    @PostMapping
    public String saveCliente(@ModelAttribute Cliente cliente) {
        clienteService.save(cliente);
        return "redirect:/clientes"; 
    }

    @GetMapping("/edit/{id}")
    public String editCliente(@PathVariable("id") Long id, Model model) {
        Cliente cliente = clienteService.getClienteById(id);
        List<Cliente> clientes = clienteService.getClientes();
        model.addAttribute("cliente", cliente);
        model.addAttribute("clientes", clientes); 
        return "clientes"; 
    }

    @PostMapping("/delete/{id}")
    public String deleteCliente(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        try {
            clienteService.deleteById(id);
            redirectAttributes.addFlashAttribute("message", "Cliente eliminado correctamente.");
        } catch (DataIntegrityViolationException e) {
            redirectAttributes.addFlashAttribute("error", "No se puede eliminar el cliente porque tiene registros asociados.");
        }
        return "redirect:/clientes"; 
    }
}
