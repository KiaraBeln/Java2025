package com.examenkiaratorales.examenjava.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examenkiaratorales.examenjava.model.Producto;
import com.examenkiaratorales.examenjava.repository.ProductoRepository;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepository repo;

    public List<Producto> listar() {
        return repo.findAll();
    }

    public Producto guardar(Producto producto) {
        if (producto.getPrecio() <= 0 || producto.getCantidad() < 0) {
            throw new IllegalArgumentException("Precio debe ser mayor a 0 y cantidad no puede ser negativa");
        }
        return repo.save(producto);
    }

    public Producto actualizar(Long id, Producto datos) {
        Producto prod = repo.findById(id).orElseThrow();
        if (datos.getPrecio() <= 0 || datos.getCantidad() < 0) {
            throw new IllegalArgumentException("Precio debe ser mayor a 0 y cantidad no puede ser negativa");
        }
        prod.setNombre(datos.getNombre());
        prod.setDescripcion(datos.getDescripcion());
        prod.setCantidad(datos.getCantidad());
        prod.setPrecio(datos.getPrecio());
        return repo.save(prod);
    }

    public void eliminar(Long id) {
        repo.deleteById(id);
    }

    public Producto obtenerPorId(Long id) {
        return repo.findById(id).orElseThrow();
    }
}
