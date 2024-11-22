package com.example.demo.controller;

import com.example.demo.domain.Descuento;
import com.example.demo.service.DescuentoService;
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
@RequestMapping("/descuento")
public class DescuentoController {

    @Autowired
    private DescuentoService descuentoService;

    @GetMapping("/listado")
    public String listado(Model model) {
        var lista = descuentoService.getDescuentos();
        model.addAttribute("descuentos", lista);
        model.addAttribute("totalDescuentos", lista.size());
        return "/descuento/listado";
    }

    @PostMapping("/guardar")
    public String save(Descuento descuento) {
        descuentoService.save(descuento);
        return "redirect:/descuento/listado";
    }

    @GetMapping("/modifica/{descuentoId}")
    public String modifica(@PathVariable("descuentoId") Long descuentoId, Model model) {
        Descuento descuento = descuentoService.getDescuento(new Descuento(descuentoId));
        model.addAttribute("descuento", descuento);
        return "/descuento/modifica";
    }

    @GetMapping("/eliminar/{descuentoId}")
    public String elimina(@PathVariable("descuentoId") Long descuentoId) {
        descuentoService.delete(new Descuento(descuentoId));
        return "redirect:/descuento/listado";
    }
}