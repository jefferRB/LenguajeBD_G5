package com.example.demo.serviceImpl;

import com.example.demo.conexion.Conexion;
import com.example.demo.domain.Cliente;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.service.ClienteService;
import com.example.demo.dao.ClienteDao;
import jakarta.transaction.Transactional;
import java.sql.Connection;
import ora_query.Ora_Cliente;

/**
 *
 * @author jeffer
 */
@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteDao clienteDao;
    private Ora_Cliente clien = new Ora_Cliente();

    @Override
    @Transactional(readOnly = true)
    public List<Cliente> getClientes() {
        var lista = clienteDao.findAll();

        return lista;
    }

    @Override
    @Transactional(readOnly = true)
    public Cliente getCliente(Cliente cliente) {
        return clienteDao.findById(cliente.getClienteId()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Cliente cliente) {
        clienteDao.save(cliente);
    }

    @Override
    @Transactional
    public void delete(Cliente cliente) {
        clienteDao.delete(cliente);
    }

    @Override
    @Transactional
    public void update(Cliente cliente) {
        Connection conn = Conexion.getConnection();
        try {
            clien.modificarCliente(conn, cliente);
        } catch (Exception e) {
            e.getMessage();
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.getMessage();
            }
        }
    }

    @Override
    @Transactional
    public int getClientesSize() {
        Connection conn = Conexion.getConnection();
        try {
            return clien.getClientesSize(conn);

        } catch (Exception e) {
            e.getMessage();
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.getMessage();
            }
        }
        return 0;
    }

}
