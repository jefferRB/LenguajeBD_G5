package com.example.demo.serviceImpl;

import com.example.demo.dao.MetodoPagoDao;
import com.example.demo.domain.MetodoPago;
import com.example.demo.service.MetodoPagoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    @Transactional(readOnly = true)
    public List<MetodoPago> getMetodosPago() {
        return metodoPagoDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public MetodoPago getMetodoPago(MetodoPago metodoPago) {
        return metodoPagoDao.findById(metodoPago.getMetodoPagoId()).orElse(null);
    }

    @Override
    @Transactional
    public void save(MetodoPago metodoPago) {
        metodoPagoDao.save(metodoPago);
    }

    @Override
    @Transactional
    public void delete(MetodoPago metodoPago) {
        metodoPagoDao.delete(metodoPago);
    }
}