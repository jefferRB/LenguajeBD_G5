package com.example.demo.service;

import com.example.demo.domain.Telefono;
import java.util.List;

public interface TelefonoService {

    List<Telefono> getTelefonos();

    Telefono getTelefono(Telefono telefono);

    Telefono getTelefonoById(Long id); 

    void save(Telefono telefono);

    void delete(Telefono telefono);

    void deleteById(Long id); 
}
