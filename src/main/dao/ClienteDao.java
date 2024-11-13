package com.proyecto.dao;

import com.proyecto.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author jeffe
 */
public interface ClienteDao extends 
        JpaRepository<Cliente, Long> {
}
