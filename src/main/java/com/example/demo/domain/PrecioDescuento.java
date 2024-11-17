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
@Table(name = "PrecioDescuento")
public class PrecioDescuento implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DescuentoID")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ProductoID", nullable = false)
    private Producto producto;

    @Column(name = "Precio", nullable = false)
    private double precio;

    @Column(name = "Descuento")
    private double descuento;

    @Column(name = "FechaInicio", nullable = false)
    private LocalDate fechaInicio;

    @Column(name = "FechaFin")
    private LocalDate fechaFin;
}