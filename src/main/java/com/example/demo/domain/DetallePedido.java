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
@Table(name = "DETALLE_PEDIDOS")
public class DetallePedido implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DETALLE_PEDIDO_ID")
    private Long detallePedidoId;

    @Column(name = "PEDIDO_ID", nullable = false)
    private Long pedidoId;

    @Column(name = "PRODUCTO_ID", nullable = false)
    private Long productoId;

    @Column(name = "CANTIDAD", nullable = false)
    private Integer cantidad;

    // Constructor adicional para la clave primaria
    public DetallePedido(Long detallePedidoId) {
        this.detallePedidoId = detallePedidoId;
    }
}
