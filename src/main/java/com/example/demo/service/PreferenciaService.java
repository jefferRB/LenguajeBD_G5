package com.example.demo.service;

import com.example.demo.domain.Preferencia;
import java.util.List;

public interface PreferenciaService {

    List<Preferencia> getPreferencias();

    Preferencia getPreferencia(Preferencia preferencia);

    Preferencia getPreferenciaById(Long id); // Método adicional para obtener preferencia por ID

    void save(Preferencia preferencia);

    void delete(Preferencia preferencia);

    void deleteById(Long id); // Método adicional para eliminar por ID
}
