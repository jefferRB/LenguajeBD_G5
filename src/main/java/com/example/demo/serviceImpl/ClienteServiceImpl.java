package com.example.demo.serviceImpl;

import com.example.demo.dao.ClienteDao;
import com.example.demo.dao.PreferenciaDao;
import com.example.demo.domain.Cliente;
import com.example.demo.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteDao clienteDao;

    @Override
    @Transactional(readOnly = true)
    public List<Cliente> getClientes() {
        return clienteDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Cliente getCliente(Cliente cliente) {
        return clienteDao.findById(cliente.getClienteId()).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public Cliente getClienteById(Long id) {
        return clienteDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void save(Cliente cliente) {
        if (cliente.getClienteId() != null) {
            
            Cliente clienteExistente = clienteDao.findById(cliente.getClienteId()).orElse(null);
            if (clienteExistente != null) {
                clienteExistente.setNombre(cliente.getNombre());
                clienteExistente.setPapellido(cliente.getPapellido());
                clienteExistente.setSapellido(cliente.getSapellido());
                clienteExistente.setCorreo(cliente.getCorreo());
                clienteExistente.setPreferencias(cliente.getPreferencias());
                clienteDao.save(clienteExistente);
                return;
            }
        }
       
        clienteDao.save(cliente);
    }


    @Override
    @Transactional
    public void delete(Cliente cliente) {
        clienteDao.delete(cliente);
    }

    @Autowired
    private PreferenciaDao preferenciaDao;

    @Transactional
    @Override
    public void deleteById(Long id) {
        preferenciaDao.deleteByClienteId(id);
        clienteDao.deleteById(id); 
    }
}
