package com.example.demo.service;

import com.example.demo.domain.Descuento;
import java.util.List;

public interface DescuentoService {

    List<Descuento> getDescuentos();

    Descuento getDescuento(Descuento descuento);

    Descuento getDescuentoById(Long id); 

    void save(Descuento descuento);

    void delete(Descuento descuento);

    void deleteById(Long id); 
}
