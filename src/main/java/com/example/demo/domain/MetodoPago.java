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
@Table(name = "METODO_PAGOS")
public class MetodoPago implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "METODO_PAGO_ID")
    private Long metodoPagoId;

    @Column(name = "DESCRIPCION_PAGO", nullable = false, length = 100)
    private String descripcionPago;

    // Constructor adicional para la clave primaria
    public MetodoPago(Long metodoPagoId) {
        this.metodoPagoId = metodoPagoId;
    }
}
