package com.example.demo.domain;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

/**
 *
 * @author Tom
 */
@Data
@Entity
@Table(name = "DetallePedido")
public class DetallePedido implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DetallePedidoID")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ProductoID", nullable = false)
    private Producto producto;

    @ManyToOne
    @JoinColumn(name = "PedidoID", nullable = false)
    private Pedido pedido;

    @Column(name = "Cantidad", nullable = false)
    private int cantidad;

    @Column(name = "PrecioUnidad", nullable = false)
    private double precioUnidad;
}