package com.example.demo.dao;

import com.example.demo.domain.Inventario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author Tom
 */
public interface InventarioDao extends JpaRepository<Inventario, Long> {
}
