package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.domain.DetallePedido;
import com.example.demo.service.DetallePedidoService;


/**
 *
 * @author Tom
 */
@Controller
@RequestMapping("/detalle-pedidos")
public class DetallePedidoController {

    @Autowired
    private DetallePedidoService detallePedidoService;

    @GetMapping
    public List<DetallePedido> getAll() {
        return detallePedidoService.getDetalles();
    }

    @GetMapping("/{id}")
    public DetallePedido getById(@PathVariable Long id) {
        return detallePedidoService.getDetalleById(id);
    }

    @PostMapping
    public void save(@RequestBody DetallePedido detallePedido) {
        detallePedidoService.save(detallePedido);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        detallePedidoService.delete(id);
    }
}