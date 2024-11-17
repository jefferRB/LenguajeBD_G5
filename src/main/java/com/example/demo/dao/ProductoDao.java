package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.domain.Producto;

/**
 *
 * @author Tom
 */
public interface ProductoDao extends 
        JpaRepository<Producto, Long> {
}
