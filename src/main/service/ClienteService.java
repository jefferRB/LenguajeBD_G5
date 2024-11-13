package com.proyecto.service;


import com.proyecto.domain.Cliente;
import java.util.List;

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
