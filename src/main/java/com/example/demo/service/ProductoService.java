package com.example.demo.service;

import com.example.demo.domain.Producto;
import java.util.List;

/**
 *
 * @author Tom
 */
public interface ProductoService {

    List<Producto> getProductos();

    Producto getProducto(Producto producto);

    void save(Producto producto);

    void delete(Producto producto);
}