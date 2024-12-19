package com.example.demo.serviceImpl;

import com.example.demo.dao.DescuentoDao;
import com.example.demo.domain.Descuento;
import com.example.demo.service.DescuentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DescuentoServiceImpl implements DescuentoService {

    @Autowired
    private DescuentoDao descuentoDao;

    @Override
    @Transactional(readOnly = true)
    public List<Descuento> getDescuentos() {
        return descuentoDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Descuento getDescuento(Descuento descuento) {
        return descuentoDao.findById(descuento.getDescuentoId()).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public Descuento getDescuentoById(Long id) {
        return descuentoDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void save(Descuento descuento) {
        descuentoDao.save(descuento);
    }

    @Override
    @Transactional
    public void delete(Descuento descuento) {
        descuentoDao.delete(descuento);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        descuentoDao.deleteById(id);
    }
}
