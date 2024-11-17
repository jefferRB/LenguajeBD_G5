package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.domain.PrecioDescuento;

/**
 *
 * @author Tom
 */
public interface PrecioDescuentoDao extends JpaRepository<PrecioDescuento, Long> {
}
