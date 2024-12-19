package com.example.demo.service;

import com.example.demo.domain.TipoMetodo;
import java.util.List;

public interface TipoMetodoService {

    List<TipoMetodo> getTiposMetodo();

    TipoMetodo getTipoMetodo(TipoMetodo tipoMetodo);

    TipoMetodo getTipoMetodoById(Long id); 

    void save(TipoMetodo tipoMetodo);

    void delete(TipoMetodo tipoMetodo);

    void deleteById(Long id); 
}
