package com.example.demo.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.PrecioDescuentoDao;
import com.example.demo.domain.PrecioDescuento;
import com.example.demo.service.PrecioDescuentoService;

/**
 *
 * @author Tom
 */
@Service
public class PrecioDescuentoServiceImpl implements PrecioDescuentoService {

    @Autowired
    private PrecioDescuentoDao precioDescuentoDao;

    @Override
    public List<PrecioDescuento> listarPreciosDescuento() {
        return (List<PrecioDescuento>) precioDescuentoDao.findAll();
    }

    @Override
    public PrecioDescuento guardarPrecioDescuento(PrecioDescuento precioDescuento) {
        return precioDescuentoDao.save(precioDescuento);
    }

    @Override
    public void eliminarPrecioDescuento(Long id) {
        precioDescuentoDao.deleteById(id);
    }

    @Override
    public PrecioDescuento encontrarPrecioDescuentoPorId(Long id) {
        return precioDescuentoDao.findById(id).orElse(null);
    }
}
