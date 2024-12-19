package com.example.demo.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "TIPOMETODOS")
public class TipoMetodo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TIPO_METODO_ID")
    private Long tipoMetodoId;

    @Column(name = "METODO_PAGO_ID", nullable = false)
    private Long metodoPagoId;

  
    public TipoMetodo(Long tipoMetodoId) {
        this.tipoMetodoId = tipoMetodoId;
    }
}
