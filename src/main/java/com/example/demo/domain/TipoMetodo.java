package com.example.demo.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import lombok.Data;

/**
 *
 * @author Tom
 */
@Data
@Entity
@Table(name = "TipoMetodo")
public class TipoMetodo implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TipoMetodoID")
    private Long id;

    @Column(name = "Nombre", nullable = false)
    private String nombre;
}