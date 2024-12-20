package com.example.demo.service;

import com.example.demo.domain.Pedido;
import java.util.List;

public interface PedidoService {

    List<Pedido> getPedidos();

    Pedido getPedido(Pedido pedido);

    Pedido getPedidoById(Long id); 

    void save(Pedido pedido);

    void delete(Pedido pedido);

    void deleteById(Long id); 
}
