package com.example.demo.dao;

import com.example.demo.domain.Preferencia;
import org.springframework.data.jpa.repository.JpaRepository;
/**
 *
 * @author Tom
 */
public interface PreferenciaDao extends JpaRepository<Preferencia, Long> {
}