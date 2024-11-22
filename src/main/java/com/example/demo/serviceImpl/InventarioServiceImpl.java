package com.example.demo.serviceImpl;

import com.example.demo.dao.InventarioDao;
import com.example.demo.domain.Inventario;
import com.example.demo.service.InventarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 *
 * @author Tom
 */
@Service
public class InventarioServiceImpl implements InventarioService {

    @Autowired
    private InventarioDao inventarioDao;

    @Override
    @Transactional(readOnly = true)
    public List<Inventario> getInventarios() {
        return inventarioDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Inventario getInventario(Inventario inventario) {
        return inventarioDao.findById(inventario.getInventarioId()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Inventario inventario) {
        inventarioDao.save(inventario);
    }

    @Override
    @Transactional
    public void delete(Inventario inventario) {
        inventarioDao.delete(inventario);
    }
}