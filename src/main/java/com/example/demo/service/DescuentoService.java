package com.example.demo.service;

import com.example.demo.domain.Descuento;
import java.util.List;

/**
 *
 * @author Tom
 */
public interface DescuentoService {

    List<Descuento> getDescuentos();

    Descuento getDescuento(Descuento descuento);

    void save(Descuento descuento);

    void delete(Descuento descuento);
}