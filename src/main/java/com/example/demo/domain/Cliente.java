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
    @Column(name = "cedula")
    private Long CLIENTE_ID;
    private String NOMBRE;
    private String P_APELLIDO;
    private String S_APELLIDO;
    private String CORREO;
 

}
