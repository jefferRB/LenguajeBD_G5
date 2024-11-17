package com.example.demo.serviceImpl;

import com.example.demo.dao.ProductoDao;
import com.example.demo.domain.Producto;
import com.example.demo.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 * @author Tom
 */
@Service
public class ProductoServiceImpl implements ProductoService {

    @Autowired
    private ProductoDao productoDao;

    @Override
    public List<Producto> getProductos() {
        return productoDao.findAll();
    }

    @Override
    public Producto getProductoById(Long id) {
        return productoDao.findById(id).orElse(null);
    }

    @Override
    public void save(Producto producto) {
        productoDao.save(producto);
    }

    @Override
    public void update(Long id, Producto producto) {
        producto.setId(id);
        productoDao.save(producto);
    }

    @Override
    public void delete(Long id) {
        productoDao.deleteById(id);
    }
}