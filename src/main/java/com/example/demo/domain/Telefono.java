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
@Table(name = "TELEFONOS")
public class Telefono implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TELEFONO_ID")
    private Long telefonoId;

    @Column(name = "CLIENTE_ID", nullable = false)
    private Long clienteId;

    @Column(name = "TELEFONO", nullable = false, length = 15)
    private String telefono;

    // Constructor adicional para la clave primaria
    public Telefono(Long telefonoId) {
        this.telefonoId = telefonoId;
    }
}
