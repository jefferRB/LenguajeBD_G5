package com.example.demo.controller;

import com.example.demo.domain.Descuento;
import com.example.demo.service.DescuentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/descuentos")
public class DescuentoController {

    @Autowired
    private DescuentoService descuentoService;

    @GetMapping
    public String listDescuentos(Model model) {
        List<Descuento> descuentos = descuentoService.getDescuentos();
        model.addAttribute("descuentos", descuentos);
        model.addAttribute("descuento", new Descuento()); 
        return "descuentos";
    }

    @PostMapping
    public String saveDescuento(@ModelAttribute Descuento descuento) {
        descuentoService.save(descuento);
        return "redirect:/descuentos";
    }

    @GetMapping("/edit/{id}")
    public String editDescuento(@PathVariable("id") Long id, Model model) {
        Descuento descuento = descuentoService.getDescuentoById(id);
        List<Descuento> descuentos = descuentoService.getDescuentos(); 
        model.addAttribute("descuento", descuento);
        model.addAttribute("descuentos", descuentos);
        return "descuentos"; 
    }

    @PostMapping("/delete/{id}")
    public String deleteDescuento(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        try {
            descuentoService.deleteById(id);
            redirectAttributes.addFlashAttribute("message", "Descuento eliminado correctamente.");
        } catch (DataIntegrityViolationException e) {
            redirectAttributes.addFlashAttribute("error", "No se puede eliminar el descuento porque tiene registros asociados.");
        }
        return "redirect:/descuentos"; 
    }
}
