package com.example.demo.service;

import com.example.demo.domain.Telefono;
import java.util.List;

public interface TelefonoService {

    List<Telefono> getTelefonos();

    Telefono getTelefono(Telefono telefono);

    Telefono getTelefonoById(Long id); // Método adicional para obtener teléfono por ID

    void save(Telefono telefono);

    void delete(Telefono telefono);

    void deleteById(Long id); // Método adicional para eliminar por ID
}
