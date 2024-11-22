package com.example.demo.controller;

import com.example.demo.domain.DetallePedido;
import com.example.demo.service.DetallePedidoService;
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
@RequestMapping("/detallePedido")
public class DetallePedidoController {

    @Autowired
    private DetallePedidoService detallePedidoService;

    @GetMapping("/listado")
    public String listado(Model model) {
        var lista = detallePedidoService.getDetallesPedido();
        model.addAttribute("detallesPedido", lista);
        model.addAttribute("totalDetalles", lista.size());
        return "/detallePedido/listado";
    }

    @PostMapping("/guardar")
    public String save(DetallePedido detallePedido) {
        detallePedidoService.save(detallePedido);
        return "redirect:/detallePedido/listado";
    }

    @GetMapping("/modifica/{detallePedidoId}")
    public String modifica(@PathVariable("detallePedidoId") Long detallePedidoId, Model model) {
        DetallePedido detallePedido = detallePedidoService.getDetallePedido(new DetallePedido(detallePedidoId));
        model.addAttribute("detallePedido", detallePedido);
        return "/detallePedido/modifica";
    }

    @GetMapping("/eliminar/{detallePedidoId}")
    public String elimina(@PathVariable("detallePedidoId") Long detallePedidoId) {
        detallePedidoService.delete(new DetallePedido(detallePedidoId));
        return "redirect:/detallePedido/listado";
    }
}