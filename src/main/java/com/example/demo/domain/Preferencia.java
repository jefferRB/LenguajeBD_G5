package com.example.demo.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "PREFERENCIAS")
public class Preferencia implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PREFERENCIAS_ID")
    private Long preferenciaId;

    @Column(name = "PREFERENCIA", nullable = false, length = 255)
    private String preferencia;

    @ManyToOne
    @JoinColumn(name = "CLIENTE_ID", nullable = false) 
    private Cliente cliente;

   
    public Preferencia(Long preferenciaId) {
        this.preferenciaId = preferenciaId;
    }
}
