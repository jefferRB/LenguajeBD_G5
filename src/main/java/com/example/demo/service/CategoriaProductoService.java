package com.example.demo.service;

import com.example.demo.domain.CategoriaProducto;
import java.util.List;

public interface CategoriaProductoService {

    List<CategoriaProducto> getCategorias();

    CategoriaProducto getCategoria(CategoriaProducto categoria);

    CategoriaProducto getCategoriaById(Long id); 

    void save(CategoriaProducto categoria);

    void delete(CategoriaProducto categoria);

    void deleteById(Long id); 
}
