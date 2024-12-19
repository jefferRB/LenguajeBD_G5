package com.example.demo.service;

import com.example.demo.domain.DetallePedido;
import java.util.List;

public interface DetallePedidoService {

    List<DetallePedido> getDetallesPedido();

    DetallePedido getDetallePedido(DetallePedido detallePedido);

    DetallePedido getDetallePedidoById(Long id); // Método adicional para obtener detalle de pedido por ID

    void save(DetallePedido detallePedido);

    void delete(DetallePedido detallePedido);

    void deleteById(Long id); // Método adicional para eliminar por ID
}
