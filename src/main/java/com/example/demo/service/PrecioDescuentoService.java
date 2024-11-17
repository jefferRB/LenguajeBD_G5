package com.example.demo.service;

import java.util.List;

import com.example.demo.domain.PrecioDescuento;

/**
 *
 * @author jeffer
 */
public interface PrecioDescuentoService {
    List<PrecioDescuento> listarPreciosDescuento();
    PrecioDescuento guardarPrecioDescuento(PrecioDescuento precioDescuento);
    void eliminarPrecioDescuento(Long id);
    PrecioDescuento encontrarPrecioDescuentoPorId(Long id);
}