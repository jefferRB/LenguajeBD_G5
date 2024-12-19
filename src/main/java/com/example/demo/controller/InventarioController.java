package com.example.demo.controller;

import com.example.demo.domain.Inventario;
import com.example.demo.service.InventarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/inventarios")
public class InventarioController {

    @Autowired
    private InventarioService inventarioService;

    @GetMapping
    public String listInventarios(Model model) {
        List<Inventario> inventarios = inventarioService.getInventarios();
        model.addAttribute("inventarios", inventarios);
        model.addAttribute("inventario", new Inventario()); 
        return "inventarios"; 
    }

    @PostMapping
    public String saveInventario(@ModelAttribute Inventario inventario) {
        inventarioService.save(inventario);
        return "redirect:/inventarios"; 
    }

    @GetMapping("/edit/{id}")
    public String editInventario(@PathVariable("id") Long id, Model model) {
        Inventario inventario = inventarioService.getInventarioById(id);
        List<Inventario> inventarios = inventarioService.getInventarios(); 
        model.addAttribute("inventario", inventario);
        model.addAttribute("inventarios", inventarios);
        return "inventarios";
    }

    @PostMapping("/delete/{id}")
    public String deleteInventario(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        try {
            inventarioService.deleteById(id);
            redirectAttributes.addFlashAttribute("message", "Inventario eliminado correctamente.");
        } catch (DataIntegrityViolationException e) {
            redirectAttributes.addFlashAttribute("error", "No se puede eliminar el inventario porque tiene registros asociados.");
        }
        return "redirect:/inventarios"; 
    }
}
