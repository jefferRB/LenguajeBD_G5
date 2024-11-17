package com.example.demo.service;

import com.example.demo.domain.Producto;
import java.util.List;

/**
 *
 * @author Tom
 */
public interface ProductoService {
    List<Producto> getProductos();
    Producto getProductoById(Long id);
    void save(Producto producto);
    void update(Long id, Producto producto);
    void delete(Long id);
}