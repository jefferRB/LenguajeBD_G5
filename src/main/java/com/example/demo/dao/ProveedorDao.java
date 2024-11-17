package com.example.demo.dao;

import com.example.demo.domain.Proveedor;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Tom
 */
public interface ProveedorDao extends 
        JpaRepository<Proveedor, Long> {
}
