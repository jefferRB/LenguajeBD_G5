package com.example.demo.domain;

import java.io.Serializable;
import java.time.LocalDate;

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
@Table(name = "Pedido")
public class Pedido implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PedidoID")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "MetodoPagoID", nullable = false)
    private MetodoPago metodoPago;

    @ManyToOne
    @JoinColumn(name = "ClienteID", nullable = false)
    private Cliente cliente;

    @Column(name = "EstadoPedido", nullable = false)
    private String estadoPedido;

    @Column(name = "FechaEstimacion")
    private LocalDate fechaEstimacion;

    @Column(name = "FechaPedido", nullable = false)
    private LocalDate fechaPedido;
}