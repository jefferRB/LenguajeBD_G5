package com.example.demo.dao;

import com.example.demo.domain.Inventario;
import org.springframework.data.jpa.repository.JpaRepository;
/**
 *
 * @author Tom
 */
public interface InventarioDao extends JpaRepository<Inventario, Long> {
}