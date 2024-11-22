package com.example.demo.serviceImpl;

import com.example.demo.dao.PreferenciaDao;
import com.example.demo.domain.Preferencia;
import com.example.demo.service.PreferenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
/**
 *
 * @author Tom
 */
@Service
public class PreferenciaServiceImpl implements PreferenciaService {

    @Autowired
    private PreferenciaDao preferenciaDao;

    @Override
    @Transactional(readOnly = true)
    public List<Preferencia> getPreferencias() {
        return preferenciaDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Preferencia getPreferencia(Preferencia preferencia) {
        return preferenciaDao.findById(preferencia.getPreferenciaId()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Preferencia preferencia) {
        preferenciaDao.save(preferencia);
    }

    @Override
    @Transactional
    public void delete(Preferencia preferencia) {
        preferenciaDao.delete(preferencia);
    }
}