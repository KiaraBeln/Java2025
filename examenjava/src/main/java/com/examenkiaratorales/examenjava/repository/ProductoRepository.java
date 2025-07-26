package com.examenkiaratorales.examenjava.repository;

import com.examenkiaratorales.examenjava.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Long> {

}
