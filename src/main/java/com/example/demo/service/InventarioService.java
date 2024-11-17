package com.example.demo.service;

import java.util.List;

import com.example.demo.domain.Inventario;

/**
 *
 * @author Tom
 */
public interface InventarioService {
    List<Inventario> listarInventarios();
    Inventario guardarInventario(Inventario inventario);
    void eliminarInventario(Long id);
    Inventario encontrarInventarioPorId(Long id);
}
