package com.example.demo.dao;

import com.example.demo.domain.Preferencia;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author Tom
 */
public interface PreferenciaDao extends JpaRepository<Preferencia, Long> {
    @Transactional
    @Modifying
    @Query("DELETE FROM Preferencia p WHERE p.cliente.clienteId = :clienteId")
    void deleteByClienteId(Long clienteId);
}