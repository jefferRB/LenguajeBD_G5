package com.example.demo.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@Entity
@Table(name = "clientes")
@NoArgsConstructor
@AllArgsConstructor
public class Cliente implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cliente_seq")
    @SequenceGenerator(name = "cliente_seq", sequenceName = "cliente_seq", allocationSize = 1)
    @Column(name = "CLIENTE_ID")
    private Long clienteId;

    @Column(name = "NOMBRE")
    private String nombre;

    @Column(name = "P_APELLIDO")
    private String papellido;

    @Column(name = "S_APELLIDO")
    private String sapellido;


    @Column(name = "CORREO")
    private String correo;


    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Preferencia> preferencias;

    public void setPreferencias(List<Preferencia> preferencias) {
        if (this.preferencias != null) {
            this.preferencias.clear();
        }
        if (preferencias != null) {
            this.preferencias.addAll(preferencias);
        }


    }
}
