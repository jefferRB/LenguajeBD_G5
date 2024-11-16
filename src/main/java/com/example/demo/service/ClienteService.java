package com.example.demo.service;


import java.util.List;

import com.example.demo.domain.Cliente;

/**
 *
 * @author jeffer
 */
public interface ClienteService {

    public List<Cliente> getClientes();

    public Cliente getCliente(Cliente cliente);

    public void save(Cliente cliente);

    public void delete(Cliente cliente);
}
