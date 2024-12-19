package com.example.demo.service;

import com.example.demo.domain.Precio;
import java.util.List;

public interface PrecioService {

    List<Precio> getPrecios();

    Precio getPrecio(Precio precio);

    Precio getPrecioById(Long id); 

    void save(Precio precio);

    void delete(Precio precio);

    void deleteById(Long id); 
}
