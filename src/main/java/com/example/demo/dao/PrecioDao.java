package com.example.demo.dao;

import com.example.demo.domain.Precio;
import org.springframework.data.jpa.repository.JpaRepository;
/**
 *
 * @author Tom
 */
public interface PrecioDao extends JpaRepository<Precio, Long> {
}