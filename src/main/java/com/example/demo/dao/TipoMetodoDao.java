package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.domain.TipoMetodo;

/**
 *
 * @author Tom
 */
public interface TipoMetodoDao extends JpaRepository<TipoMetodo, Long> {
}