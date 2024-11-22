package com.example.demo.service;

import com.example.demo.domain.Inventario;
import java.util.List;

/**
 *
 * @author Tom
 */
public interface InventarioService {

    List<Inventario> getInventarios();

    Inventario getInventario(Inventario inventario);

    void save(Inventario inventario);

    void delete(Inventario inventario);
}