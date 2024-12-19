package com.example.demo.serviceImpl;

import com.example.demo.dao.TelefonoDao;
import com.example.demo.domain.Telefono;
import com.example.demo.service.TelefonoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TelefonoServiceImpl implements TelefonoService {

    @Autowired
    private TelefonoDao telefonoDao;

    @Override
    @Transactional(readOnly = true)
    public List<Telefono> getTelefonos() {
        return telefonoDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Telefono getTelefono(Telefono telefono) {
        return telefonoDao.findById(telefono.getTelefonoId()).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public Telefono getTelefonoById(Long id) {
        return telefonoDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void save(Telefono telefono) {
        telefonoDao.save(telefono);
    }

    @Override
    @Transactional
    public void delete(Telefono telefono) {
        telefonoDao.delete(telefono);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        telefonoDao.deleteById(id);
    }
}
