package com.example.demo.service;

import com.example.demo.domain.Proveedor;
import java.util.List;

/**
 *
 * @author Tom
 */
public interface ProveedorService {
    List<Proveedor> getProveedores();
    Proveedor getProveedorById(Long id);
    void save(Proveedor proveedor);
    void update(Long id, Proveedor proveedor);
    void delete(Long id);
}
