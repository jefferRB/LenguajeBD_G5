package com.example.demo.service;

import com.example.demo.domain.Proveedor;
import java.util.List;

/**
 *
 * @author Tom
 */

public interface ProveedorService {

    List<Proveedor> getProveedores();

    Proveedor getProveedor(Proveedor proveedor);

    Proveedor getProveedorById(Long id); 

    void save(Proveedor proveedor);

    void delete(Proveedor proveedor);

    void deleteById(Long id); 
}
