package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.domain.DetallePedido;

/**
 *
 * @author Tom
 */
public interface DetallePedidoDao extends JpaRepository<DetallePedido, Long> {
}