package com.example.demo.serviceImpl;

import com.example.demo.dao.DetallePedidoDao;
import com.example.demo.domain.DetallePedido;
import com.example.demo.service.DetallePedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DetallePedidoServiceImpl implements DetallePedidoService {

    @Autowired
    private DetallePedidoDao detallePedidoDao;

    @Override
    @Transactional(readOnly = true)
    public List<DetallePedido> getDetallesPedido() {
        return detallePedidoDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public DetallePedido getDetallePedido(DetallePedido detallePedido) {
        return detallePedidoDao.findById(detallePedido.getDetallePedidoId()).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public DetallePedido getDetallePedidoById(Long id) {
        return detallePedidoDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void save(DetallePedido detallePedido) {
        detallePedidoDao.save(detallePedido);
    }

    @Override
    @Transactional
    public void delete(DetallePedido detallePedido) {
        detallePedidoDao.delete(detallePedido);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        detallePedidoDao.deleteById(id);
    }
}
