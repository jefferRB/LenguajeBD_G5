package com.example.demo.service;

import java.util.List;

import com.example.demo.domain.DetallePedido;

/**
 *
 * @author Tom
 */
public interface DetallePedidoService {
    List<DetallePedido> getDetalles();
    DetallePedido getDetalleById(Long id);
    void save(DetallePedido detallePedido);
    void delete(Long id);
}
