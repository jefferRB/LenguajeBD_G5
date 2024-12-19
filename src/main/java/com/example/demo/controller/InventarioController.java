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
        model.addAttribute("inventario", new Inventario()); // Para el formulario de agregar
        return "inventarios"; // Nombre de la vista
    }

    @PostMapping
    public String saveInventario(@ModelAttribute Inventario inventario) {
        inventarioService.save(inventario);
        return "redirect:/inventarios"; // Redirigir a la lista de inventarios
    }

    @GetMapping("/edit/{id}")
    public String editInventario(@PathVariable("id") Long id, Model model) {
        Inventario inventario = inventarioService.getInventarioById(id);
        List<Inventario> inventarios = inventarioService.getInventarios(); // Cargar nuevamente la lista de inventarios
        model.addAttribute("inventario", inventario);
        model.addAttribute("inventarios", inventarios); // Asegurarse de que la lista se envíe a la vista
        return "inventarios"; // Nombre de la vista
    }

    @PostMapping("/delete/{id}")
    public String deleteInventario(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        try {
            inventarioService.deleteById(id);
            redirectAttributes.addFlashAttribute("message", "Inventario eliminado correctamente.");
        } catch (DataIntegrityViolationException e) {
            redirectAttributes.addFlashAttribute("error", "No se puede eliminar el inventario porque tiene registros asociados.");
        }
        return "redirect:/inventarios"; // Redirigir a la lista de inventarios
    }
}
