package com.example.demo.service;

import com.example.demo.domain.CategoriaProducto;
import java.util.List;

/**
 *
 * @author Tom
 */
public interface CategoriaProductoService {

    List<CategoriaProducto> getCategorias();

    CategoriaProducto getCategoria(CategoriaProducto categoria);

    void save(CategoriaProducto categoria);

    void delete(CategoriaProducto categoria);
}