package com.example.demo.dao;

import com.example.demo.domain.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Tom
 */
public interface PedidoDao extends JpaRepository<Pedido, Long> {
}