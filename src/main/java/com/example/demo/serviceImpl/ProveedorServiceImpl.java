package com.example.demo.serviceImpl;

import com.example.demo.dao.ProveedorDao;
import com.example.demo.domain.Proveedor;
import com.example.demo.service.ProveedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    @Transactional(readOnly = true)
    public List<Proveedor> getProveedores() {
        return proveedorDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Proveedor getProveedor(Proveedor proveedor) {
        return proveedorDao.findById(proveedor.getProveedorId()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Proveedor proveedor) {
        proveedorDao.save(proveedor);
    }

    @Override
    @Transactional
    public void delete(Proveedor proveedor) {
        proveedorDao.delete(proveedor);
    }
}