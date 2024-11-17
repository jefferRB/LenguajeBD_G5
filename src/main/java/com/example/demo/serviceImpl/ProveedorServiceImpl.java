package com.example.demo.serviceImpl;

import com.example.demo.dao.ProveedorDao;
import com.example.demo.domain.Proveedor;
import com.example.demo.service.ProveedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 * @author Tom
 */
@Service
public class ProveedorServiceImpl implements ProveedorService {

    @Autowired
    private ProveedorDao proveedorDao;

    @Override
    public List<Proveedor> getProveedores() {
        return proveedorDao.findAll();
    }

    @Override
    public Proveedor getProveedorById(Long id) {
        return proveedorDao.findById(id).orElse(null);
    }

    @Override
    public void save(Proveedor proveedor) {
        proveedorDao.save(proveedor);
    }

    @Override
    public void update(Long id, Proveedor proveedor) {
        proveedor.setId(id);
        proveedorDao.save(proveedor);
    }

    @Override
    public void delete(Long id) {
        proveedorDao.deleteById(id);
    }
}