package com.example.demo.service;

import java.util.List;

import com.example.demo.domain.Cliente;

/**
 *
 * @author jeffer
 */
public interface ClienteService {

    List<Cliente> getClientes();

    Cliente getCliente(Cliente cliente);

    void save(Cliente cliente);

    void delete(Cliente cliente);
}