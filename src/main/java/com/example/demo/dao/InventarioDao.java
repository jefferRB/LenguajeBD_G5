package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.domain.Inventario;

/**
 *
 * @author Tom
 */
public interface InventarioDao extends JpaRepository<Inventario, Long> {
}
