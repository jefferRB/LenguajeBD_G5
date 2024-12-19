package com.example.demo.controller;

import com.example.demo.domain.DetallePedido;
import com.example.demo.service.DetallePedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/detalle_pedidos")
public class DetallePedidoController {

    @Autowired
    private DetallePedidoService detallePedidoService;

    @GetMapping
    public String listDetallePedidos(Model model) {
        List<DetallePedido> detallePedidos = detallePedidoService.getDetallesPedido();
        model.addAttribute("detallePedidos", detallePedidos);
        model.addAttribute("detallePedido", new DetallePedido()); // Para el formulario de agregar
        return "detalle_pedidos"; // Nombre de la vista
    }

    @PostMapping
    public String saveDetallePedido(@ModelAttribute DetallePedido detallePedido) {
        detallePedidoService.save(detallePedido);
        return "redirect:/detalle_pedidos"; // Redirigir a la lista de detalle de pedidos
    }

    @GetMapping("/edit/{id}")
    public String editDetallePedido(@PathVariable("id") Long id, Model model) {
        DetallePedido detallePedido = detallePedidoService.getDetallePedidoById(id);
        List<DetallePedido> detallePedidos = detallePedidoService.getDetallesPedido(); // Cargar nuevamente la lista de detalle de pedidos
        model.addAttribute("detallePedido", detallePedido);
        model.addAttribute("detallePedidos", detallePedidos); // Asegurarse de que la lista se envíe a la vista
        return "detalle_pedidos"; // Nombre de la vista
    }

    @PostMapping("/delete/{id}")
    public String deleteDetallePedido(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        try {
            detallePedidoService.deleteById(id);
            redirectAttributes.addFlashAttribute("message", "Detalle de pedido eliminado correctamente.");
        } catch (DataIntegrityViolationException e) {
            redirectAttributes.addFlashAttribute("error", "No se puede eliminar el detalle del pedido porque tiene registros asociados.");
        }
        return "redirect:/detalle_pedidos"; // Redirigir a la lista de detalle de pedidos
    }
}
