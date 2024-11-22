package com.example.demo.service;

import com.example.demo.domain.Telefono;
import java.util.List;

/**
 *
 * @author Tom
 */
public interface TelefonoService {

    List<Telefono> getTelefonos();

    Telefono getTelefono(Telefono telefono);

    void save(Telefono telefono);

    void delete(Telefono telefono);
}