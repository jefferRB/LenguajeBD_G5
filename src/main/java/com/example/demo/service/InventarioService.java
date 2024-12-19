package com.example.demo.service;

import com.example.demo.domain.Inventario;
import java.util.List;

public interface InventarioService {

    List<Inventario> getInventarios();

    Inventario getInventarioById(Long id); // Método adicional para obtener inventario por ID

    void save(Inventario inventario);

    void delete(Inventario inventario);

    void deleteById(Long id); // Método adicional para eliminar por ID
}
