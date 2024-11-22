package com.example.demo.domain;

import jakarta.persistence.*;
<<<<<<< Updated upstream

import java.io.Serializable;
=======
import lombok.AllArgsConstructor;
>>>>>>> Stashed changes
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;

/**
 *
 * @author jeffer
 */
@Data
<<<<<<< Updated upstream
=======
@AllArgsConstructor
@NoArgsConstructor
>>>>>>> Stashed changes
@Entity
@Table(name = "CLIENTES")
public class Cliente implements Serializable {

<<<<<<< Updated upstream
    private static final long serialVersionUID = 1l;
    @Id
    @Column(name = "CLIENTE_ID")
    private Long clienteId;
=======
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long clienteId;

    @Column(name = "NOMBRE", nullable = false, length = 50)
>>>>>>> Stashed changes
    private String nombre;
    private String pApellido;
    private String sApellido;
    private String correo;
 

<<<<<<< Updated upstream
}
=======
    @Column(name = "P_APELLIDO", nullable = false, length = 50)
    private String primerApellido;

    @Column(name = "S_APELLIDO", nullable = false, length = 50)
    private String segundoApellido;

    @Column(name = "CORREO", nullable = false, length = 100)
    private String correo;

   
    public Cliente(Long clienteId) {
        this.clienteId = clienteId;
    }
}
>>>>>>> Stashed changes
