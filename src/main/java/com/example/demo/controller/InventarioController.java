package com.example.demo.controller;

import com.example.demo.domain.Inventario;
import com.example.demo.service.InventarioService;
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
@RequestMapping("/inventario")
public class InventarioController {

    @Autowired
    private InventarioService inventarioService;

    @GetMapping("/listado")
    public String listado(Model model) {
        var lista = inventarioService.getInventarios();
        model.addAttribute("inventarios", lista);
        model.addAttribute("totalInventarios", lista.size());
        return "/inventario/listado";
    }

    @PostMapping("/guardar")
    public String save(Inventario inventario) {
        inventarioService.save(inventario);
        return "redirect:/inventario/listado";
    }

    @GetMapping("/modifica/{inventarioId}")
    public String modifica(@PathVariable("inventarioId") Long inventarioId, Model model) {
        Inventario inventario = inventarioService.getInventario(new Inventario(inventarioId));
        model.addAttribute("inventario", inventario);
        return "/inventario/modifica";
    }

    @GetMapping("/eliminar/{inventarioId}")
    public String elimina(@PathVariable("inventarioId") Long inventarioId) {
        inventarioService.delete(new Inventario(inventarioId));
        return "redirect:/inventario/listado";
    }
}