package com.example.demo.controller;

import com.example.demo.domain.Precio;
import com.example.demo.service.PrecioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/precios")
public class PrecioController {

    @Autowired
    private PrecioService precioService;

    @GetMapping
    public String listPrecios(Model model) {
        List<Precio> precios = precioService.getPrecios();
        model.addAttribute("precios", precios);
        model.addAttribute("precio", new Precio()); // Para el formulario de agregar
        return "precios"; // Nombre de la vista
    }

    @PostMapping
    public String savePrecio(@ModelAttribute Precio precio) {
        precioService.save(precio);
        return "redirect:/precios"; // Redirigir a la lista de precios
    }

    @GetMapping("/edit/{id}")
    public String editPrecio(@PathVariable("id") Long id, Model model) {
        Precio precio = precioService.getPrecioById(id);
        List<Precio> precios = precioService.getPrecios(); // Cargar nuevamente la lista de precios
        model.addAttribute("precio", precio);
        model.addAttribute("precios", precios); // Asegurarse de que la lista se envíe a la vista
        return "precios"; // Nombre de la vista
    }

    @PostMapping("/delete/{id}")
    public String deletePrecio(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        try {
            precioService.deleteById(id);
            redirectAttributes.addFlashAttribute("message", "Precio eliminado correctamente.");
        } catch (DataIntegrityViolationException e) {
            redirectAttributes.addFlashAttribute("error", "No se puede eliminar el precio porque tiene registros asociados.");
        }
        return "redirect:/precios"; // Redirigir a la lista de precios
    }
}
