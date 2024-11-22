package com.example.demo.serviceImpl;

import com.example.demo.dao.PrecioDao;
import com.example.demo.domain.Precio;
import com.example.demo.service.PrecioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 *
 * @author Tom
 */
@Service
public class PrecioServiceImpl implements PrecioService {

    @Autowired
    private PrecioDao precioDao;

    @Override
    @Transactional(readOnly = true)
    public List<Precio> getPrecios() {
        return precioDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Precio getPrecio(Precio precio) {
        return precioDao.findById(precio.getPrecioId()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Precio precio) {
        precioDao.save(precio);
    }

    @Override
    @Transactional
    public void delete(Precio precio) {
        precioDao.delete(precio);
    }
}