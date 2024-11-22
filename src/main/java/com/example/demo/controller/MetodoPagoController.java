package com.example.demo.controller;

import com.example.demo.domain.MetodoPago;
import com.example.demo.service.MetodoPagoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 *
 * @author Tom
 */
@Controller
@RequestMapping("/metodoPago")
public class MetodoPagoController {

    @Autowired
    private MetodoPagoService metodoPagoService;

    @GetMapping("/listado")
    public String listado(Model model) {
        var lista = metodoPagoService.getMetodosPago();
        model.addAttribute("metodosPago", lista);
        model.addAttribute("totalMetodosPago", lista.size());
        return "/metodoPago/listado";
    }

    @PostMapping("/guardar")
    public String save(MetodoPago metodoPago) {
        metodoPagoService.save(metodoPago);
        return "redirect:/metodoPago/listado";
    }

    @GetMapping("/modifica/{metodoPagoId}")
    public String modifica(@PathVariable("metodoPagoId") Long metodoPagoId, Model model) {
        MetodoPago metodoPago = metodoPagoService.getMetodoPago(new MetodoPago(metodoPagoId));
        model.addAttribute("metodoPago", metodoPago);
        return "/metodoPago/modifica";
    }

    @GetMapping("/eliminar/{metodoPagoId}")
    public String elimina(@PathVariable("metodoPagoId") Long metodoPagoId) {
        metodoPagoService.delete(new MetodoPago(metodoPagoId));
        return "redirect:/metodoPago/listado";
    }
}