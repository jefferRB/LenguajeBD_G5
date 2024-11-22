package com.example.demo.controller;

import com.example.demo.domain.Precio;
import com.example.demo.service.PrecioService;
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
@RequestMapping("/precio")
public class PrecioController {

    @Autowired
    private PrecioService precioService;

    @GetMapping("/listado")
    public String listado(Model model) {
        var lista = precioService.getPrecios();
        model.addAttribute("precios", lista);
        model.addAttribute("totalPrecios", lista.size());
        return "/precio/listado";
    }

    @PostMapping("/guardar")
    public String save(Precio precio) {
        precioService.save(precio);
        return "redirect:/precio/listado";
    }

    @GetMapping("/modifica/{precioId}")
    public String modifica(@PathVariable("precioId") Long precioId, Model model) {
        Precio precio = precioService.getPrecio(new Precio(precioId));
        model.addAttribute("precio", precio);
        return "/precio/modifica";
    }

    @GetMapping("/eliminar/{precioId}")
    public String elimina(@PathVariable("precioId") Long precioId) {
        precioService.delete(new Precio(precioId));
        return "redirect:/precio/listado";
    }
}