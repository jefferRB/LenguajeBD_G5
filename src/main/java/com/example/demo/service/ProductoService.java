package com.example.demo.service;

import com.example.demo.domain.Producto;
import java.util.List;

public interface ProductoService {

    List<Producto> getProductos();

    Producto getProducto(Producto producto);

    Producto getProductoById(Long id); // Método adicional para obtener producto por ID

    void save(Producto producto);

    void delete(Producto producto);

    void deleteById(Long id); // Método adicional para eliminar por ID
}
