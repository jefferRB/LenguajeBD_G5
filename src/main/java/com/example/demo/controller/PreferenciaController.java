package com.example.demo.controller;

import com.example.demo.domain.Preferencia;
import com.example.demo.service.PreferenciaService;
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
@RequestMapping("/preferencia")
public class PreferenciaController {

    @Autowired
    private PreferenciaService preferenciaService;

    @GetMapping("/listado")
    public String listado(Model model) {
        var lista = preferenciaService.getPreferencias();
        model.addAttribute("preferencias", lista);
        model.addAttribute("totalPreferencias", lista.size());
        return "/preferencia/listado";
    }

    @PostMapping("/guardar")
    public String save(Preferencia preferencia) {
        preferenciaService.save(preferencia);
        return "redirect:/preferencia/listado";
    }

    @GetMapping("/modifica/{preferenciaId}")
    public String modifica(@PathVariable("preferenciaId") Long preferenciaId, Model model) {
        Preferencia preferencia = preferenciaService.getPreferencia(new Preferencia(preferenciaId));
        model.addAttribute("preferencia", preferencia);
        return "/preferencia/modifica";
    }

    @GetMapping("/eliminar/{preferenciaId}")
    public String elimina(@PathVariable("preferenciaId") Long preferenciaId) {
        preferenciaService.delete(new Preferencia(preferenciaId));
        return "redirect:/preferencia/listado";
    }
}