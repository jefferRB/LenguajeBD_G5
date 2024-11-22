package com.example.demo.dao;

import com.example.demo.domain.CategoriaProducto;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Tom
 */
public interface CategoriaProductoDao extends JpaRepository<CategoriaProducto, Long> {
}
