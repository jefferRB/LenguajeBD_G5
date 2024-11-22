package com.example.demo.controller;

import com.example.demo.domain.Pedido;
import com.example.demo.service.PedidoService;
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
@RequestMapping("/pedido")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @GetMapping("/listado")
    public String listado(Model model) {
        var lista = pedidoService.getPedidos();
        model.addAttribute("pedidos", lista);
        model.addAttribute("totalPedidos", lista.size());
        return "/pedido/listado";
    }

    @PostMapping("/guardar")
    public String save(Pedido pedido) {
        pedidoService.save(pedido);
        return "redirect:/pedido/listado";
    }

    @GetMapping("/modifica/{pedidoId}")
    public String modifica(@PathVariable("pedidoId") Long pedidoId, Model model) {
        Pedido pedido = pedidoService.getPedido(new Pedido(pedidoId));
        model.addAttribute("pedido", pedido);
        return "/pedido/modifica";
    }

    @GetMapping("/eliminar/{pedidoId}")
    public String elimina(@PathVariable("pedidoId") Long pedidoId) {
        pedidoService.delete(new Pedido(pedidoId));
        return "redirect:/pedido/listado";
    }
}