package com.example.demo.service;

import java.util.List;

import com.example.demo.domain.CategoriaProducto;

/**
 *
 * @author Tom
 */
public interface CategoriaProductoService {
    List<CategoriaProducto> getCategorias();
    CategoriaProducto getCategoriaById(Long id);
    void save(CategoriaProducto categoriaProducto);
    void update(Long id, CategoriaProducto categoriaProducto);
    void delete(Long id);
}
