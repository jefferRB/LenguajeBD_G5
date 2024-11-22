package com.example.demo.service;

import com.example.demo.domain.DetallePedido;
import java.util.List;

/**
 *
 * @author Tom
 */
public interface DetallePedidoService {

    List<DetallePedido> getDetallesPedido();

    DetallePedido getDetallePedido(DetallePedido detallePedido);

    void save(DetallePedido detallePedido);

    void delete(DetallePedido detallePedido);
}