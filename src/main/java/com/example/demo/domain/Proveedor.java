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
@Table(name = "PROVEEDORES")
public class Proveedor implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long proveedorId;

    @Column(name = "NOMBRE", nullable = false, length = 100)
    private String nombre;

    @Column(name = "PRIMER_APELLIDO", nullable = true, length = 100)
    private String primerApellido;

    @Column(name = "SEGUNDO_APELLIDO", nullable = true, length = 100)
    private String segundoApellido;

    @Column(name = "CONTACTO", nullable = false, length = 20)
    private String contacto;

    @Column(name = "CONDICIONES_COMPRA", nullable = true, length = 200)
    private String condicionesCompra;

  
    public Proveedor(Long proveedorId) {
        this.proveedorId = proveedorId;
    }
}