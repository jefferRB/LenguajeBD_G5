package com.example.demo.service;

import com.example.demo.domain.Cliente;
import java.util.List;
/**
 *
 * @author jeffer
 */
public interface ClienteService {

    List<Cliente> getClientes();

    Cliente getCliente(Cliente cliente);

    Cliente getClienteById(Long id);

    void save(Cliente cliente);

    void delete(Cliente cliente);

    void deleteById(Long id);
}