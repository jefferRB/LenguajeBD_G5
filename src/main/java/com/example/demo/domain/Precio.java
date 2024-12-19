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
@Table(name = "PRECIOS")
public class Precio implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PRECIO_ID")
    private Long precioId;

    @Column(name = "PRODUCTO_ID", nullable = false)
    private Long productoId;

    @Column(name = "PRECIO", nullable = false)
    private Double precio;

    @Column(name = "FECHA_VIGENCIA", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaVigencia;

  
    public Precio(Long precioId) {
        this.precioId = precioId;
    }
}
