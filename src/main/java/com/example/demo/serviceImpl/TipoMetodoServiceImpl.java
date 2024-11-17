package com.example.demo.serviceImpl;

import com.example.demo.dao.TipoMetodoDao;
import com.example.demo.domain.TipoMetodo;
import com.example.demo.service.TipoMetodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 * @author Tom
 */
@Service
public class TipoMetodoServiceImpl implements TipoMetodoService {

    @Autowired
    private TipoMetodoDao tipoMetodoDao;

    @Override
    public List<TipoMetodo> getTipos() {
        return tipoMetodoDao.findAll();
    }

    @Override
    public TipoMetodo getTipoById(Long id) {
        return tipoMetodoDao.findById(id).orElse(null);
    }

    @Override
    public void save(TipoMetodo tipoMetodo) {
        tipoMetodoDao.save(tipoMetodo);
    }

    @Override
    public void update(Long id, TipoMetodo tipoMetodo) {
        tipoMetodo.setId(id);
        tipoMetodoDao.save(tipoMetodo);
    }

    @Override
    public void delete(Long id) {
        tipoMetodoDao.deleteById(id);
    }
}