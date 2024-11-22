package com.example.demo.controller;

import com.example.demo.domain.CategoriaProducto;
import com.example.demo.service.CategoriaProductoService;
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
@RequestMapping("/categoriaProducto")
public class CategoriaProductoController {

    @Autowired
    private CategoriaProductoService categoriaProductoService;

    @GetMapping("/listado")
    public String listado(Model model) {
        var lista = categoriaProductoService.getCategorias();
        model.addAttribute("categorias", lista);
        model.addAttribute("totalCategorias", lista.size());
        return "/categoriaProducto/listado";
    }

    @PostMapping("/guardar")
    public String save(CategoriaProducto categoria) {
        categoriaProductoService.save(categoria);
        return "redirect:/categoriaProducto/listado";
    }

    @GetMapping("/modifica/{categoriaId}")
    public String modifica(@PathVariable("categoriaId") Long categoriaId, Model model) {
        CategoriaProducto categoria = categoriaProductoService.getCategoria(new CategoriaProducto(categoriaId));
        model.addAttribute("categoria", categoria);
        return "/categoriaProducto/modifica";
    }

    @GetMapping("/eliminar/{categoriaId}")
    public String elimina(@PathVariable("categoriaId") Long categoriaId) {
        categoriaProductoService.delete(new CategoriaProducto(categoriaId));
        return "redirect:/categoriaProducto/listado";
    }
}