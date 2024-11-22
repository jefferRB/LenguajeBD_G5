package com.example.demo.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Tom
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "PEDIDOS")
public class Pedido implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pedidoId;

    @Column(name = "METODO_PAGO_ID", nullable = false)
    private Long metodoPagoId;

    @Column(name = "CLIENTE_ID", nullable = false)
    private Long clienteId;

    @Column(name = "ESTADO_PEDIDO", nullable = false, length = 50)
    private String estadoPedido;

    @Column(name = "FECHA_ESTIMACION", nullable = true)
    @Temporal(TemporalType.DATE)
    private Date fechaEstimacion;

    @Column(name = "FECHA_PEDIDO", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaPedido;

   
    public Pedido(Long pedidoId) {
        this.pedidoId = pedidoId;
    }
}