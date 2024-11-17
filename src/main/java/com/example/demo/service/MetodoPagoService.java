package com.example.demo.service;

import java.util.List;

import com.example.demo.domain.MetodoPago;

/**
 *
 * @author Tom
 */
public interface MetodoPagoService {
    List<MetodoPago> getMetodos();
    MetodoPago getMetodoById(Long id);
    void save(MetodoPago metodoPago);
    void update(Long id, MetodoPago metodoPago);
    void delete(Long id);
}