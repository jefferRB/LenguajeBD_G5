package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.domain.CategoriaProducto;

/**
 *
 * @author Tom
 */
public interface CategoriaProductoDao extends JpaRepository<CategoriaProducto, Long> {
}
