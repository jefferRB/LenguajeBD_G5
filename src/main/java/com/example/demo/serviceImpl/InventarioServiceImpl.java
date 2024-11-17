package com.example.demo.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.InventarioDao;
import com.example.demo.domain.Inventario;
import com.example.demo.service.InventarioService;

/**
 *
 * @author Tom
 */
@Service
public class InventarioServiceImpl implements InventarioService {

    @Autowired
    private InventarioDao inventarioDao;

    @Override
    public List<Inventario> listarInventarios() {
        return (List<Inventario>) inventarioDao.findAll();
    }

    @Override
    public Inventario guardarInventario(Inventario inventario) {
        return inventarioDao.save(inventario);
    }

    @Override
    public void eliminarInventario(Long id) {
        inventarioDao.deleteById(id);
    }

    @Override
    public Inventario encontrarInventarioPorId(Long id) {
        return inventarioDao.findById(id).orElse(null);
    }
}