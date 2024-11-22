package com.example.demo.dao;

import com.example.demo.domain.Telefono;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Tom
 */
public interface TelefonoDao extends JpaRepository<Telefono, Long> {
}
