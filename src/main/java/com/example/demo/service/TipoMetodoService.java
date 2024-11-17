package com.example.demo.service;

import com.example.demo.domain.TipoMetodo;
import java.util.List;

/**
 *
 * @author Tom
 */
public interface TipoMetodoService {
    List<TipoMetodo> getTipos();
    TipoMetodo getTipoById(Long id);
    void save(TipoMetodo tipoMetodo);
    void update(Long id, TipoMetodo tipoMetodo);
    void delete(Long id);
}