package com.example.demo.service;

import com.example.demo.domain.TipoMetodo;
import java.util.List;

public interface TipoMetodoService {

    List<TipoMetodo> getTiposMetodo();

    TipoMetodo getTipoMetodo(TipoMetodo tipoMetodo);

    TipoMetodo getTipoMetodoById(Long id); // Método adicional para obtener tipo de método por ID

    void save(TipoMetodo tipoMetodo);

    void delete(TipoMetodo tipoMetodo);

    void deleteById(Long id); // Método adicional para eliminar por ID
}
