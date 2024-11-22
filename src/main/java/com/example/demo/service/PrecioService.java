package com.example.demo.service;

import com.example.demo.domain.Precio;
import java.util.List;

/**
 *
 * @author Tom
 */
public interface PrecioService {

    List<Precio> getPrecios();

    Precio getPrecio(Precio precio);

    void save(Precio precio);

    void delete(Precio precio);
}