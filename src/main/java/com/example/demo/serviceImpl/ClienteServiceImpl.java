package com.example.demo.serviceImpl;

import com.example.demo.domain.Cliente;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.service.ClienteService;
import com.example.demo.dao.ClienteDao;

/**
 *
 * @author jeffer
 */
@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteDao clienteDao;

    @Override
    public List<Cliente> getClientes() {
        var lista = clienteDao.findAll();

        return lista;
    }

    @Override
    public Cliente getCliente(Cliente cliente) {
        return clienteDao.findById(cliente.getCLIENTE_ID()).orElse(null);
    }

    @Override
    public void save(Cliente cliente) {
        clienteDao.save(cliente);
    }

    @Override
    public void delete(Cliente cliente) {
        clienteDao.delete(cliente);
    }
    

}
