package com.example.demo.controller;

import com.example.demo.domain.Producto;
import com.example.demo.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/productos")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @GetMapping
    public String listProductos(Model model) {
        List<Producto> productos = productoService.getProductos();
        model.addAttribute("productos", productos);
        model.addAttribute("producto", new Producto());
        return "productos"; 
    }

    @PostMapping
    public String saveProducto(@ModelAttribute Producto producto) {
        productoService.save(producto);
        return "redirect:/productos"; 
    }

    @GetMapping("/edit/{id}")
    public String editProducto(@PathVariable("id") Long id, Model model) {
        Producto producto = productoService.getProductoById(id);
        List<Producto> productos = productoService.getProductos(); 
        model.addAttribute("producto", producto);
        model.addAttribute("productos", productos); 
        return "productos"; 
    }

    @PostMapping("/delete/{id}")
    public String deleteProducto(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        try {
            productoService.deleteById(id);
            redirectAttributes.addFlashAttribute("message", "Producto eliminado correctamente.");
        } catch (DataIntegrityViolationException e) {
            redirectAttributes.addFlashAttribute("error", "No se puede eliminar el producto porque tiene registros asociados.");
        }
        return "redirect:/productos"; 
    }
}
