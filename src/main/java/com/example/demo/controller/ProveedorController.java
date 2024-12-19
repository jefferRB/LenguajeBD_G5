package com.example.demo.controller;

import com.example.demo.domain.Proveedor;
import com.example.demo.service.ProveedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/proveedores")
public class ProveedorController {

    @Autowired
    private ProveedorService proveedorService;

    @GetMapping
    public String listProveedores(Model model) {
        List<Proveedor> proveedores = proveedorService.getProveedores();
        model.addAttribute("proveedores", proveedores);
        model.addAttribute("proveedor", new Proveedor()); // Para el formulario de agregar
        return "proveedores"; // Nombre de la vista
    }

    @PostMapping
    public String saveProveedor(@ModelAttribute Proveedor proveedor) {
        proveedorService.save(proveedor);
        return "redirect:/proveedores"; // Redirigir a la lista de proveedores
    }

    @GetMapping("/edit/{id}")
    public String editProveedor(@PathVariable("id") Long id, Model model) {
        Proveedor proveedor = proveedorService.getProveedorById(id);
        List<Proveedor> proveedores = proveedorService.getProveedores(); // Cargar nuevamente la lista de proveedores
        model.addAttribute("proveedor", proveedor);
        model.addAttribute("proveedores", proveedores); // Asegurarse de que la lista se envíe a la vista
        return "proveedores"; // Nombre de la vista
    }

    @PostMapping("/delete/{id}")
    public String deleteProveedor(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        try {
            proveedorService.deleteById(id);
            redirectAttributes.addFlashAttribute("message", "Proveedor eliminado correctamente.");
        } catch (DataIntegrityViolationException e) {
            redirectAttributes.addFlashAttribute("error", "No se puede eliminar el proveedor porque tiene registros asociados.");
        }
        return "redirect:/proveedores"; // Redirigir a la lista de proveedores
    }
}
