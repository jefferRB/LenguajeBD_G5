package com.example.demo.serviceImpl;

import com.example.demo.dao.MetodoPagoDao;
import com.example.demo.domain.MetodoPago;
import com.example.demo.service.MetodoPagoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 * @author Tom
 */
@Service
public class MetodoPagoServiceImpl implements MetodoPagoService {

    @Autowired
    private MetodoPagoDao metodoPagoDao;

    @Override
    public List<MetodoPago> getMetodos() {
        return metodoPagoDao.findAll();
    }

    @Override
    public MetodoPago getMetodoById(Long id) {
        return metodoPagoDao.findById(id).orElse(null);
    }

    @Override
    public void save(MetodoPago metodoPago) {
        metodoPagoDao.save(metodoPago);
    }

    @Override
    public void update(Long id, MetodoPago metodoPago) {
        metodoPago.setId(id);
        metodoPagoDao.save(metodoPago);
    }

    @Override
    public void delete(Long id) {
        metodoPagoDao.deleteById(id);
    }
}