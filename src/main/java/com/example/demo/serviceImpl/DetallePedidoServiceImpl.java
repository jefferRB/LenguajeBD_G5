package com.example.demo.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.DetallePedidoDao;
import com.example.demo.domain.DetallePedido;
import com.example.demo.service.DetallePedidoService;

/**
 *
 * @author Tom
 */
@Service
public class DetallePedidoServiceImpl implements DetallePedidoService {

    @Autowired
    private DetallePedidoDao detallePedidoDao;

    @Override
    public List<DetallePedido> getDetalles() {
        return detallePedidoDao.findAll();
    }

    @Override
    public DetallePedido getDetalleById(Long id) {
        return detallePedidoDao.findById(id).orElse(null);
    }

    @Override
    public void save(DetallePedido detallePedido) {
        detallePedidoDao.save(detallePedido);
    }

    @Override
    public void delete(Long id) {
        detallePedidoDao.deleteById(id);
    }
}
