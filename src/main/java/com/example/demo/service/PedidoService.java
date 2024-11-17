package com.example.demo.service;

import java.util.List;

import com.example.demo.domain.Pedido;

/**
 *
 * @author Tom
 */
public interface PedidoService {
    List<Pedido> getPedidos();
    Pedido getPedidoById(Long id);
    void save(Pedido pedido);
    void update(Long id, Pedido pedido);
    void delete(Long id);
}