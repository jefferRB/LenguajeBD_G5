package com.example.demo.controller;

import com.example.demo.domain.*;
import com.example.demo.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/tienda")
public class TiendaController {

    @Autowired
    private ProductoService productoService;

    @Autowired
    private CategoriaProductoService categoriaProductoService;

    @Autowired
    private InventarioService inventarioService;

    @Autowired
    private PrecioService precioService;

    @Autowired
    private DescuentoService descuentoService;

    @Autowired
    private PedidoService pedidoService;

    @Autowired
    private DetallePedidoService detallePedidoService;

    @GetMapping
    public String showTienda(Model model) {
        List<Producto> productos = productoService.getProductos();
        List<CategoriaProducto> categorias = categoriaProductoService.getCategorias();
        model.addAttribute("productos", productos);
        model.addAttribute("categorias", categorias);
        return "tienda";
    }

    @PostMapping("/comprar")
    public String comprarProducto(@RequestParam("productoId") Long productoId,
                                  @RequestParam("cantidad") Integer cantidad, Model model) {
        Inventario inventario = inventarioService.getInventarioById(productoId);
        if (inventario != null && inventario.getCantidadDisponible() >= cantidad) {
            inventario.setCantidadDisponible(inventario.getCantidadDisponible() - cantidad);
            inventarioService.save(inventario);

            Pedido pedido = new Pedido();
            pedidoService.save(pedido);

            DetallePedido detallePedido = new DetallePedido();
            detallePedido.setPedidoId(pedido.getPedidoId());
            detallePedido.setProductoId(productoId);
            detallePedido.setCantidad(cantidad);
            detallePedidoService.save(detallePedido);

            model.addAttribute("message", "Compra realizada con éxito.");
        } else {
            model.addAttribute("error", "No hay suficiente inventario disponible.");
        }
        return "redirect:/tienda";
    }
}
