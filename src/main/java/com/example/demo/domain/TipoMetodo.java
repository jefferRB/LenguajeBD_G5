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
@Table(name = "TIPOMETODOS")
public class TipoMetodo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tipoMetodoId;

    @Column(name = "METODO_PAGO_ID", nullable = false)
    private Long metodoPagoId;

  
    public TipoMetodo(Long tipoMetodoId) {
        this.tipoMetodoId = tipoMetodoId;
    }
}