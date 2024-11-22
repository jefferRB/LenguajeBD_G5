package com.example.demo.dao;

import com.example.demo.domain.MetodoPago;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Tom
 */
public interface MetodoPagoDao extends JpaRepository<MetodoPago, Long> {
}