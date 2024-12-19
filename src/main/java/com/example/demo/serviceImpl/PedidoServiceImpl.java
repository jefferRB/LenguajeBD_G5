package com.example.demo.serviceImpl;

import com.example.demo.dao.PedidoDao;
import com.example.demo.domain.Pedido;
import com.example.demo.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PedidoServiceImpl implements PedidoService {

    @Autowired
    private PedidoDao pedidoDao;

    @Override
    @Transactional(readOnly = true)
    public List<Pedido> getPedidos() {
        return pedidoDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Pedido getPedido(Pedido pedido) {
        return pedidoDao.findById(pedido.getPedidoId()).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public Pedido getPedidoById(Long id) {
        return pedidoDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void save(Pedido pedido) {
        pedidoDao.save(pedido);
    }

    @Override
    @Transactional
    public void delete(Pedido pedido) {
        pedidoDao.delete(pedido);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        pedidoDao.deleteById(id);
    }
}
