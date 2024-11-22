package com.example.demo.controller;

import com.example.demo.domain.TipoMetodo;
import com.example.demo.service.TipoMetodoService;
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
@RequestMapping("/tipoMetodo")
public class TipoMetodoController {

    @Autowired
    private TipoMetodoService tipoMetodoService;

    @GetMapping("/listado")
    public String listado(Model model) {
        var lista = tipoMetodoService.getTiposMetodo();
        model.addAttribute("tiposMetodo", lista);
        model.addAttribute("totalTiposMetodo", lista.size());
        return "/tipoMetodo/listado";
    }

    @PostMapping("/guardar")
    public String save(TipoMetodo tipoMetodo) {
        tipoMetodoService.save(tipoMetodo);
        return "redirect:/tipoMetodo/listado";
    }

    @GetMapping("/modifica/{tipoMetodoId}")
    public String modifica(@PathVariable("tipoMetodoId") Long tipoMetodoId, Model model) {
        TipoMetodo tipoMetodo = tipoMetodoService.getTipoMetodo(new TipoMetodo(tipoMetodoId));
        model.addAttribute("tipoMetodo", tipoMetodo);
        return "/tipoMetodo/modifica";
    }

    @GetMapping("/eliminar/{tipoMetodoId}")
    public String elimina(@PathVariable("tipoMetodoId") Long tipoMetodoId) {
        tipoMetodoService.delete(new TipoMetodo(tipoMetodoId));
        return "redirect:/tipoMetodo/listado";
    }
}