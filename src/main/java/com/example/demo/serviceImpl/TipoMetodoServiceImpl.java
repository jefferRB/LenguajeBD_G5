package com.example.demo.serviceImpl;

import com.example.demo.dao.TipoMetodoDao;
import com.example.demo.domain.TipoMetodo;
import com.example.demo.service.TipoMetodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TipoMetodoServiceImpl implements TipoMetodoService {

    @Autowired
    private TipoMetodoDao tipoMetodoDao;

    @Override
    @Transactional(readOnly = true)
    public List<TipoMetodo> getTiposMetodo() {
        return tipoMetodoDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public TipoMetodo getTipoMetodo(TipoMetodo tipoMetodo) {
        return tipoMetodoDao.findById(tipoMetodo.getTipoMetodoId()).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public TipoMetodo getTipoMetodoById(Long id) {
        return tipoMetodoDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void save(TipoMetodo tipoMetodo) {
        tipoMetodoDao.save(tipoMetodo);
    }

    @Override
    @Transactional
    public void delete(TipoMetodo tipoMetodo) {
        tipoMetodoDao.delete(tipoMetodo);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        tipoMetodoDao.deleteById(id);
    }
}
