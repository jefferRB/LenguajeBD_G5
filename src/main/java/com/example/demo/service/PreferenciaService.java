package com.example.demo.service;

import com.example.demo.domain.Preferencia;
import java.util.List;
/**
 *
 * @author Tom
 */
public interface PreferenciaService {

    List<Preferencia> getPreferencias();

    Preferencia getPreferencia(Preferencia preferencia);

    void save(Preferencia preferencia);

    void delete(Preferencia preferencia);
}
