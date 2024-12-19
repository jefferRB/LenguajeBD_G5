package com.example.demo.service;

import com.example.demo.domain.MetodoPago;
import java.util.List;

public interface MetodoPagoService {

    List<MetodoPago> getMetodosPago();

    MetodoPago getMetodoPago(MetodoPago metodoPago);

    MetodoPago getMetodoPagoById(Long id); // Método adicional para obtener método de pago por ID

    void save(MetodoPago metodoPago);

    void delete(MetodoPago metodoPago);

    void deleteById(Long id); // Método adicional para eliminar por ID
}
