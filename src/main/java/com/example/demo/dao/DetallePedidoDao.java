package com.example.demo.dao;

import com.example.demo.domain.DetallePedido;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Tom
 */
public interface DetallePedidoDao extends JpaRepository<DetallePedido, Long> {
}