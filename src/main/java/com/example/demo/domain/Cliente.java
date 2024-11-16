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
    private Long id;
    private String nombre;
    private String primerApellido;
    private String segundoApellido;
    private String email;
    private String password;

}
