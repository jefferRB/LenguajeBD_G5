package com.example.demo.service;

import com.example.demo.domain.TipoMetodo;
import java.util.List;

/**
 *
 * @author Tom
 */
public interface TipoMetodoService {

    List<TipoMetodo> getTiposMetodo();

    TipoMetodo getTipoMetodo(TipoMetodo tipoMetodo);

    void save(TipoMetodo tipoMetodo);

    void delete(TipoMetodo tipoMetodo);
}