package com.example.demo.controller;

import com.example.demo.domain.Preferencia;
import com.example.demo.service.PreferenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/preferencias")
public class PreferenciaController {

    @Autowired
    private PreferenciaService preferenciaService;

    @GetMapping
    public String listPreferencias(Model model) {
        List<Preferencia> preferencias = preferenciaService.getPreferencias();
        model.addAttribute("preferencias", preferencias);
        model.addAttribute("preferencia", new Preferencia()); // Para el formulario de agregar
        return "preferencias"; // Nombre de la vista
    }

    @PostMapping
    public String savePreferencia(@ModelAttribute Preferencia preferencia) {
        preferenciaService.save(preferencia);
        return "redirect:/preferencias"; // Redirigir a la lista de preferencias
    }

    @GetMapping("/edit/{id}")
    public String editPreferencia(@PathVariable("id") Long id, Model model) {
        Preferencia preferencia = preferenciaService.getPreferenciaById(id);
        List<Preferencia> preferencias = preferenciaService.getPreferencias(); // Cargar nuevamente la lista de preferencias
        model.addAttribute("preferencia", preferencia);
        model.addAttribute("preferencias", preferencias); // Asegurarse de que la lista se envíe a la vista
        return "preferencias"; // Nombre de la vista
    }

    @PostMapping("/delete/{id}")
    public String deletePreferencia(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        try {
            preferenciaService.deleteById(id);
            redirectAttributes.addFlashAttribute("message", "Preferencia eliminada correctamente.");
        } catch (DataIntegrityViolationException e) {
            redirectAttributes.addFlashAttribute("error", "No se puede eliminar la preferencia porque tiene registros asociados.");
        }
        return "redirect:/preferencias"; // Redirigir a la lista de preferencias
    }
}
