package com.example.demo.serviceImpl;

import com.example.demo.dao.PedidoDao;
import com.example.demo.domain.Pedido;
import com.example.demo.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 *
 * @author Tom
 */
@Service
public class PedidoServiceImpl implements PedidoService {

    @Autowired
    private PedidoDao pedidoDao;

    @Override
    public List<Pedido> getPedidos() {
        return pedidoDao.findAll();
    }

    @Override
    public Pedido getPedidoById(Long id) {
        return pedidoDao.findById(id).orElse(null);
    }

    @Override
    public void save(Pedido pedido) {
        pedidoDao.save(pedido);
    }

    @Override
    public void update(Long id, Pedido pedido) {
        pedido.setId(id);
        pedidoDao.save(pedido);
    }

    @Override
    public void delete(Long id) {
        pedidoDao.deleteById(id);
    }
}