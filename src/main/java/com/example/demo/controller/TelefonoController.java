package com.example.demo.controller;

import com.example.demo.domain.Telefono;
import com.example.demo.service.TelefonoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/telefonos")
public class TelefonoController {

    @Autowired
    private TelefonoService telefonoService;

    @GetMapping
    public String listTelefonos(Model model) {
        List<Telefono> telefonos = telefonoService.getTelefonos();
        model.addAttribute("telefonos", telefonos);
        model.addAttribute("telefono", new Telefono()); 
        return "telefonos"; 
    }

    @PostMapping
    public String saveTelefono(@ModelAttribute Telefono telefono) {
        telefonoService.save(telefono);
        return "redirect:/telefonos"; 
    }

    @GetMapping("/edit/{id}")
    public String editTelefono(@PathVariable("id") Long id, Model model) {
        Telefono telefono = telefonoService.getTelefonoById(id);
        List<Telefono> telefonos = telefonoService.getTelefonos(); 
        model.addAttribute("telefono", telefono);
        model.addAttribute("telefonos", telefonos);
        return "telefonos"; 
    }

    @PostMapping("/delete/{id}")
    public String deleteTelefono(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        try {
            telefonoService.deleteById(id);
            redirectAttributes.addFlashAttribute("message", "Teléfono eliminado correctamente.");
        } catch (DataIntegrityViolationException e) {
            redirectAttributes.addFlashAttribute("error", "No se puede eliminar el teléfono porque tiene registros asociados.");
        }
        return "redirect:/telefonos"; 
    }
}
