package com.example.demo.controller;

import com.example.demo.domain.Producto;
import com.example.demo.service.ProductoService;
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
@RequestMapping("/producto")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @GetMapping("/listado")
    public String listado(Model model) {
        var lista = productoService.getProductos();
        model.addAttribute("productos", lista);
        model.addAttribute("totalProductos", lista.size());
        return "/producto/listado";
    }

    @PostMapping("/guardar")
    public String save(Producto producto) {
        productoService.save(producto);
        return "redirect:/producto/listado";
    }

    @GetMapping("/modifica/{productoId}")
    public String modifica(@PathVariable("productoId") Long productoId, Model model) {
        Producto producto = productoService.getProducto(new Producto(productoId));
        model.addAttribute("producto", producto);
        return "/producto/modifica";
    }

    @GetMapping("/eliminar/{productoId}")
    public String elimina(@PathVariable("productoId") Long productoId) {
        productoService.delete(new Producto(productoId));
        return "redirect:/producto/listado";
    }
}