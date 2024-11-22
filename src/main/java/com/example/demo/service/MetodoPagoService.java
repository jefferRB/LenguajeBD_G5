package com.example.demo.service;

import com.example.demo.domain.MetodoPago;
import java.util.List;

/**
 *
 * @author Tom
 */
public interface MetodoPagoService {

    List<MetodoPago> getMetodosPago();

    MetodoPago getMetodoPago(MetodoPago metodoPago);

    void save(MetodoPago metodoPago);

    void delete(MetodoPago metodoPago);
}