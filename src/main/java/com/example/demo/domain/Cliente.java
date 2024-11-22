package com.example.demo.domain;

import jakarta.persistence.*;

import java.io.Serializable;
import lombok.Data;

/**
 *
 * @author jeffer
 */
@Data
@Entity
@Table(name = "clientes")
public class Cliente implements Serializable {

    private static final long serialVersionUID = 1l;
    @Id
    @Column(name = "CLIENTE_ID")
    private Long clienteId;
    private String nombre;
    private String pApellido;
    private String sApellido;
    private String correo;
 

}
