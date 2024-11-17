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
@Table(name = "Producto")
public class Producto implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ProductoID")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "CategoriaID", nullable = false)
    private CategoriaProducto categoriaProducto;

    @ManyToOne
    @JoinColumn(name = "ProveedorID", nullable = false)
    private Proveedor proveedor;

    @Column(name = "Nombre", nullable = false)
    private String nombre;

    @Column(name = "Stock", nullable = false)
    private int stock;

    @Column(name = "Especificaciones")
    private String especificaciones;

    @Column(name = "Descripcion")
    private String descripcion;

    @Column(name = "Precio", nullable = false)
    private double precio;
}