package com.example.demo.controller;

import com.example.demo.domain.Proveedor;
import com.example.demo.service.ProveedorService;
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
@RequestMapping("/proveedor")
public class ProveedorController {

    @Autowired
    private ProveedorService proveedorService;

    @GetMapping("/listado")
    public String listado(Model model) {
        var lista = proveedorService.getProveedores();
        model.addAttribute("proveedores", lista);
        model.addAttribute("totalProveedores", lista.size());
        return "/proveedor/listado";
    }

    @PostMapping("/guardar")
    public String save(Proveedor proveedor) {
        proveedorService.save(proveedor);
        return "redirect:/proveedor/listado";
    }

    @GetMapping("/modifica/{proveedorId}")
    public String modifica(@PathVariable("proveedorId") Long proveedorId, Model model) {
        Proveedor proveedor = proveedorService.getProveedor(new Proveedor(proveedorId));
        model.addAttribute("proveedor", proveedor);
        return "/proveedor/modifica";
    }

    @GetMapping("/eliminar/{proveedorId}")
    public String elimina(@PathVariable("proveedorId") Long proveedorId) {
        proveedorService.delete(new Proveedor(proveedorId));
        return "redirect:/proveedor/listado";
    }
}