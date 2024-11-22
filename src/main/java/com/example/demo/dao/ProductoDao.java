package com.example.demo.dao;

import com.example.demo.domain.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Tom
 */
public interface ProductoDao extends JpaRepository<Producto, Long> {
}