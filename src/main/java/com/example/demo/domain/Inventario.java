package com.example.demo.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "INVENTARIOS")
public class Inventario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "INVENTARIO_ID")
    private Long inventarioId;

    @Column(name = "PRODUCTO_ID", nullable = false)
    private Long productoId;

    @Column(name = "ULTIMA_ACTUALIZACION", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date ultimaActualizacion;

    @Column(name = "CANTIDAD_DISPONIBLE", nullable = false)
    private Integer cantidadDisponible;

    // Constructor adicional para la clave primaria
    public Inventario(Long inventarioId) {
        this.inventarioId = inventarioId;
    }
}
