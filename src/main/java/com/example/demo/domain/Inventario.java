package com.example.demo.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import lombok.Data;

/**
 *
 * @author Tom
 */
@Data
@Entity
@Table(name = "Inventario")
public class Inventario implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "InventarioID")
    private Long id;

    @OneToOne
    @JoinColumn(name = "ProductoID", nullable = false)
    private Producto producto;

    @Column(name = "CantidadDisponible", nullable = false)
    private int cantidadDisponible;

    @Column(name = "UltimaActualizacion", nullable = false)
    private LocalDate ultimaActualizacion;
}