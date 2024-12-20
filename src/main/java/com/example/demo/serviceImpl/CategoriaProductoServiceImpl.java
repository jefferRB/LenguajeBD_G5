package com.example.demo.serviceImpl;

import com.example.demo.dao.CategoriaProductoDao;
import com.example.demo.domain.CategoriaProducto;
import com.example.demo.service.CategoriaProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CategoriaProductoServiceImpl implements CategoriaProductoService {

    @Autowired
    private CategoriaProductoDao categoriaProductoDao;

    @Override
    @Transactional(readOnly = true)
    public List<CategoriaProducto> getCategorias() {
        return categoriaProductoDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public CategoriaProducto getCategoria(CategoriaProducto categoria) {
        return categoriaProductoDao.findById(categoria.getCategoriaId()).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public CategoriaProducto getCategoriaById(Long id) {
        return categoriaProductoDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void save(CategoriaProducto categoria) {
        categoriaProductoDao.save(categoria);
    }

    @Override
    @Transactional
    public void delete(CategoriaProducto categoria) {
        categoriaProductoDao.delete(categoria);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        categoriaProductoDao.deleteById(id);
    }
}
