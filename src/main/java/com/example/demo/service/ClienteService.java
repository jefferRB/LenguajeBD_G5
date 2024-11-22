package com.example.demo.service;

<<<<<<< Updated upstream

import java.util.List;

=======
>>>>>>> Stashed changes
import com.example.demo.domain.Cliente;
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
    
    public void update(Cliente cliente);
    
    public int getClientesSize();
}
