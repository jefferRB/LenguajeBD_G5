package com.example.demo.controller;

import com.example.demo.domain.MetodoPago;
import com.example.demo.service.MetodoPagoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/metodo_pagos")
public class MetodoPagoController {

    @Autowired
    private MetodoPagoService metodoPagoService;

    @GetMapping
    public String listMetodoPagos(Model model) {
        List<MetodoPago> metodoPagos = metodoPagoService.getMetodosPago();
        model.addAttribute("metodoPagos", metodoPagos);
        model.addAttribute("metodoPago", new MetodoPago()); 
        return "metodo_pagos"; 
    }

    @PostMapping
    public String saveMetodoPago(@ModelAttribute MetodoPago metodoPago) {
        metodoPagoService.save(metodoPago);
        return "redirect:/metodo_pagos"; 
    }

    @GetMapping("/edit/{id}")
    public String editMetodoPago(@PathVariable("id") Long id, Model model) {
        MetodoPago metodoPago = metodoPagoService.getMetodoPagoById(id);
        List<MetodoPago> metodoPagos = metodoPagoService.getMetodosPago(); 
        model.addAttribute("metodoPago", metodoPago);
        model.addAttribute("metodoPagos", metodoPagos); 
        return "metodo_pagos"; 
    }

    @PostMapping("/delete/{id}")
    public String deleteMetodoPago(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        try {
            metodoPagoService.deleteById(id);
            redirectAttributes.addFlashAttribute("message", "Método de pago eliminado correctamente.");
        } catch (DataIntegrityViolationException e) {
            redirectAttributes.addFlashAttribute("error", "No se puede eliminar el método de pago porque tiene registros asociados.");
        }
        return "redirect:/metodo_pagos"; 
    }
}
