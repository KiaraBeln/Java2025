package com.examenkiaratorales.examenjava.controller;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.examenkiaratorales.examenjava.model.Producto;
import com.examenkiaratorales.examenjava.service.ProductoService;

@RestController
@RequestMapping("/productos")
public class ProductoController {

    @Autowired
    private ProductoService servicio;

    @GetMapping
    public List<Producto> listar() {
        return servicio.listar();
    }

    @GetMapping("/{id}")
    public Producto obtener(@PathVariable Long id) {
        return servicio.obtenerPorId(id);
    }

    @PostMapping
    public Producto crear(@RequestBody Producto producto) {
        return servicio.guardar(producto);
    }

    @PutMapping("/{id}")
    public Producto actualizar(@PathVariable Long id, @RequestBody Producto producto) {
        return servicio.actualizar(id, producto);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        servicio.eliminar(id);
    }

    @GetMapping("/estadisticas")
    public Map<String, Object> estadisticas() {
        List<Producto> productos = servicio.listar();

        long total = productos.size();
        double promedio = productos.stream().mapToDouble(Producto::getPrecio).average().orElse(0);
        long disponibles = productos.stream().filter(p -> p.getCantidad() > 0).count();
        long agotados = total - disponibles;

        Map<String, Object> stats = new LinkedHashMap<>();
        stats.put("totalProductos", total);
        stats.put("precioPromedio", promedio);
        stats.put("productosDisponibles", disponibles);
        stats.put("productosAgotados", agotados);
        return stats;
    }
}