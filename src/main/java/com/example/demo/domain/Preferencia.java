package com.example.demo.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;

/**
 *
 * @author Tom
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "PREFERENCIAS")
public class Preferencia implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long preferenciaId;

    @Column(name = "CLIENTE_ID", nullable = false)
    private Long clienteId;

    @Column(name = "PREFERENCIA", nullable = false, length = 255)
    private String preferencia;

    
    public Preferencia(Long preferenciaId) {
        this.preferenciaId = preferenciaId;
    }
}