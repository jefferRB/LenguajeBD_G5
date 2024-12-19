package com.example.demo.controller;

import com.example.demo.domain.CategoriaProducto;
import com.example.demo.service.CategoriaProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/categoria_productos")
public class CategoriaProductoController {

    @Autowired
    private CategoriaProductoService categoriaProductoService;

    @GetMapping
    public String listCategoriaProductos(Model model) {
        List<CategoriaProducto> categorias = categoriaProductoService.getCategorias();
        model.addAttribute("categorias", categorias);
        model.addAttribute("categoria", new CategoriaProducto()); 
        return "categoria_productos"; 
    }

    @PostMapping
    public String saveCategoriaProducto(@ModelAttribute CategoriaProducto categoria) {
        categoriaProductoService.save(categoria);
        return "redirect:/categoria_productos"; 
    }

    @GetMapping("/edit/{id}")
    public String editCategoriaProducto(@PathVariable("id") Long id, Model model) {
        CategoriaProducto categoria = categoriaProductoService.getCategoriaById(id);
        List<CategoriaProducto> categorias = categoriaProductoService.getCategorias(); 
        model.addAttribute("categoria", categoria);
        model.addAttribute("categorias", categorias); 
        return "categoria_productos"; 
    }

    @PostMapping("/delete/{id}")
    public String deleteCategoriaProducto(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        try {
            categoriaProductoService.deleteById(id);
            redirectAttributes.addFlashAttribute("message", "Categoría de producto eliminada correctamente.");
        } catch (DataIntegrityViolationException e) {
            redirectAttributes.addFlashAttribute("error", "No se puede eliminar la categoría porque tiene registros asociados.");
        }
        return "redirect:/categoria_productos"; 
    }
}
