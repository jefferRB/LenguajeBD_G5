package com.example.demo.serviceImpl;

import com.example.demo.dao.CategoriaProductoDao;
import com.example.demo.domain.CategoriaProducto;
import com.example.demo.service.CategoriaProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 * @author Tom
 */
@Service
public class CategoriaProductoServiceImpl implements CategoriaProductoService {

    @Autowired
    private CategoriaProductoDao categoriaProductoDao;

    @Override
    public List<CategoriaProducto> getCategorias() {
        return categoriaProductoDao.findAll();
    }

    @Override
    public CategoriaProducto getCategoriaById(Long id) {
        return categoriaProductoDao.findById(id).orElse(null);
    }

    @Override
    public void save(CategoriaProducto categoriaProducto) {
        categoriaProductoDao.save(categoriaProducto);
    }

    @Override
    public void update(Long id, CategoriaProducto categoriaProducto) {
        categoriaProducto.setId(id);
        categoriaProductoDao.save(categoriaProducto);
    }

    @Override
    public void delete(Long id) {
        categoriaProductoDao.deleteById(id);
    }
}