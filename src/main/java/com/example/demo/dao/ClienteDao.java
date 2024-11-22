package com.example.demo.dao;

import com.example.demo.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author jeffe
 */
public interface ClienteDao extends JpaRepository<Cliente, Long> {
}