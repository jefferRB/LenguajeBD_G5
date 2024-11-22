package com.example.demo.controller;

import com.example.demo.domain.Telefono;
import com.example.demo.service.TelefonoService;
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
@RequestMapping("/telefono")
public class TelefonoController {

    @Autowired
    private TelefonoService telefonoService;

    @GetMapping("/listado")
    public String listado(Model model) {
        var lista = telefonoService.getTelefonos();
        model.addAttribute("telefonos", lista);
        model.addAttribute("totalTelefonos", lista.size());
        return "/telefono/listado";
    }

    @PostMapping("/guardar")
    public String save(Telefono telefono) {
        telefonoService.save(telefono);
        return "redirect:/telefono/listado";
    }

    @GetMapping("/modifica/{telefonoId}")
    public String modifica(@PathVariable("telefonoId") Long telefonoId, Model model) {
        Telefono telefono = telefonoService.getTelefono(new Telefono(telefonoId));
        model.addAttribute("telefono", telefono);
        return "/telefono/modifica";
    }

    @GetMapping("/eliminar/{telefonoId}")
    public String elimina(@PathVariable("telefonoId") Long telefonoId) {
        telefonoService.delete(new Telefono(telefonoId));
        return "redirect:/telefono/listado";
    }
}