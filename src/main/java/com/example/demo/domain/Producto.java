package com.example.demo.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;
/**
 *
 * @author Tom
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "PRODUCTOS")
public class Producto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productoId;

    @Column(name = "CATEGORIA_ID", nullable = false)
    private Long categoriaId;

    @Column(name = "PROVEEDOR_ID", nullable = false)
    private Long proveedorId;

    @Column(name = "NOMBRE", nullable = false, length = 100)
    private String nombre;

    @Column(name = "STOCK", nullable = false)
    private Integer stock;

    @Column(name = "ESPECIFICACIONES", nullable = true, length = 200)
    private String especificaciones;
    
public Producto(Long productoId) {
        this.productoId = productoId;
    }
}
