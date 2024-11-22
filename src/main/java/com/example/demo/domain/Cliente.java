package com.example.demo.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;
/**
 *
 * @author jeffer
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "CLIENTES")
public class Cliente implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long clienteId;

    @Column(name = "NOMBRE", nullable = false, length = 50)
    private String nombre;

    @Column(name = "P_APELLIDO", nullable = false, length = 50)
    private String primerApellido;

    @Column(name = "S_APELLIDO", nullable = false, length = 50)
    private String segundoApellido;

    @Column(name = "CORREO", nullable = false, length = 100)
    private String correo;

    // Constructor adicional para clienteId
    public Cliente(Long clienteId) {
        this.clienteId = clienteId;
    }
}