package com.example.demo.service;

import com.example.demo.domain.Precio;
import java.util.List;

public interface PrecioService {

    List<Precio> getPrecios();

    Precio getPrecio(Precio precio);

    Precio getPrecioById(Long id); // Método adicional para obtener precio por ID

    void save(Precio precio);

    void delete(Precio precio);

    void deleteById(Long id); // Método adicional para eliminar por ID
}
