package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.domain.Cliente;

/**
 *
 * @author jeffe
 */
public interface ClienteDao extends JpaRepository<Cliente, Long> {
}