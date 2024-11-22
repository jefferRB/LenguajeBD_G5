package com.example.demo.service;

import com.example.demo.domain.Pedido;
import java.util.List;

/**
 *
 * @author Tom
 */
public interface PedidoService {

    List<Pedido> getPedidos();

    Pedido getPedido(Pedido pedido);

    void save(Pedido pedido);

    void delete(Pedido pedido);
}