package com.example.demo.controller;

import com.example.demo.domain.TipoMetodo;
import com.example.demo.service.TipoMetodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/tipometodos")
public class TipoMetodoController {

    @Autowired
    private TipoMetodoService tipoMetodoService;

    @GetMapping
    public String listTiposMetodo(Model model) {
        List<TipoMetodo> tiposMetodo = tipoMetodoService.getTiposMetodo();
        model.addAttribute("tiposMetodo", tiposMetodo);
        model.addAttribute("tipoMetodo", new TipoMetodo());
        return "tipometodos"; 
    }

    @PostMapping
    public String saveTipoMetodo(@ModelAttribute TipoMetodo tipoMetodo) {
        tipoMetodoService.save(tipoMetodo);
        return "redirect:/tipometodos"; 
    }

    @GetMapping("/edit/{id}")
    public String editTipoMetodo(@PathVariable("id") Long id, Model model) {
        TipoMetodo tipoMetodo = tipoMetodoService.getTipoMetodoById(id);
        List<TipoMetodo> tiposMetodo = tipoMetodoService.getTiposMetodo(); 
        model.addAttribute("tipoMetodo", tipoMetodo);
        model.addAttribute("tiposMetodo", tiposMetodo); 
        return "tipometodos"; 
    }

    @PostMapping("/delete/{id}")
    public String deleteTipoMetodo(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        try {
            tipoMetodoService.deleteById(id);
            redirectAttributes.addFlashAttribute("message", "Tipo de método eliminado correctamente.");
        } catch (DataIntegrityViolationException e) {
            redirectAttributes.addFlashAttribute("error", "No se puede eliminar el tipo de método porque tiene registros asociados.");
        }
        return "redirect:/tipometodos"; 
    }
}
