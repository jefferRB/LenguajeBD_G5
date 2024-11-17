package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.domain.Pedido;

/**
 *
 * @author Tom
 */
public interface PedidoDao extends 
        JpaRepository<Pedido, Long> {
}
