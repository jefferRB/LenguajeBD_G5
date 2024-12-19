package com.example.demo.controller;

import com.example.demo.domain.Pedido;
import com.example.demo.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @GetMapping
    public String listPedidos(Model model) {
        List<Pedido> pedidos = pedidoService.getPedidos();
        model.addAttribute("pedidos", pedidos);
        model.addAttribute("pedido", new Pedido()); // Para el formulario de agregar
        return "pedidos"; // Nombre de la vista
    }

    @PostMapping
    public String savePedido(@ModelAttribute Pedido pedido) {
        pedidoService.save(pedido);
        return "redirect:/pedidos"; // Redirigir a la lista de pedidos
    }

    @GetMapping("/edit/{id}")
    public String editPedido(@PathVariable("id") Long id, Model model) {
        Pedido pedido = pedidoService.getPedidoById(id);
        List<Pedido> pedidos = pedidoService.getPedidos(); // Cargar nuevamente la lista de pedidos
        model.addAttribute("pedido", pedido);
        model.addAttribute("pedidos", pedidos); // Asegurarse de que la lista se envíe a la vista
        return "pedidos"; // Nombre de la vista
    }

    @PostMapping("/delete/{id}")
    public String deletePedido(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        try {
            pedidoService.deleteById(id);
            redirectAttributes.addFlashAttribute("message", "Pedido eliminado correctamente.");
        } catch (DataIntegrityViolationException e) {
            redirectAttributes.addFlashAttribute("error", "No se puede eliminar el pedido porque tiene registros asociados.");
        }
        return "redirect:/pedidos"; // Redirigir a la lista de pedidos
    }
}
