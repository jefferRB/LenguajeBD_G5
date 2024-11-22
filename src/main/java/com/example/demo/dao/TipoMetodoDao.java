package com.example.demo.dao;

import com.example.demo.domain.TipoMetodo;
import org.springframework.data.jpa.repository.JpaRepository;
/**
 *
 * @author Tom
 */
public interface TipoMetodoDao extends JpaRepository<TipoMetodo, Long> {
}