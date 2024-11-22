package com.example.demo.dao;

import com.example.demo.domain.Descuento;
import org.springframework.data.jpa.repository.JpaRepository;
/**
 *
 * @author Tom
 */
public interface DescuentoDao extends JpaRepository<Descuento, Long> {
}