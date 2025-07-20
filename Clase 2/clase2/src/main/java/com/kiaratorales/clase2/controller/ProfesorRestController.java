package com.kiaratorales.clase2.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kiaratorales.dto.Profesor;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
@RequestMapping("/profesor")
public class ProfesorRestController {

    @Value("${sistema.clave}")
    private String claveSistema;

    public List<Profesor> lista = new ArrayList<>();
    
    @GetMapping("/mensaje/{saludo}")
    public String saludo(@PathVariable String saludo) {//Recibe un parámetro de la URL
        return "Hola, soy un profesor y te saludo con: " + saludo;
    }
    
    @GetMapping("inicio")
    public String inicio(@RequestHeader("Authorization") String clave) {//Recibe un parámetro de la cabecera
        if (clave.equals(claveSistema)) {
            return "Bienvenido al controlador de profesores con clave: " + clave;   
        } else {
            return "Clave incorrecta";
        }  
    }

     @GetMapping("/busqueda")
    public ResponseEntity<?> busqueda(@RequestParam String nombre) {//Cuando se recibe un parámetro de la URL con nombre
        if(lista.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(lista);
        }else {
            return ResponseEntity.ok(lista);
        }
    }


    @GetMapping("/listar")
    public List<Profesor> listarProfesores() {
    return lista;
    }

    @PostMapping("/crear")
    public ResponseEntity<?> creaProfesor(@RequestBody Profesor profesor) {
        for (Profesor aux : lista) {
            if (aux.obtenerClave().equals(profesor.obtenerClave())) {
                return ResponseEntity.status(HttpStatus.CONFLICT).body("El profesor ya existe");
            }
        }
        lista.add(profesor);
        return ResponseEntity.status(HttpStatus.CREATED).body("Profesor creado con éxito");
    }

    @PutMapping("/actualizar/{id}")
    public Profesor actualizaProfesor(@RequestBody Profesor profesor, @PathVariable Long id) {
        for(Profesor aux: lista){
            if(aux.getCodigoProfesor().equals(id)) {
                aux.setNombre(profesor.getNombre());
                aux.setApellido(profesor.getApellido());
                aux.setCodigoProfesor(profesor.getCodigoProfesor());
                return aux;
            }
        }
      return profesor;
    }
    
    @GetMapping("/obtener/{clave}")
    public Profesor getProfesor(@PathVariable Long clave) {
        for (Profesor profesor : lista) {
            if (profesor.obtenerClave().equals(clave)) {
                return profesor;
            }
        }
        return null; 
    }

    @DeleteMapping("/eliminar/{clave}")
    public ResponseEntity<?> eliminarProfesor(@PathVariable Long clave) {
        for (Profesor profesor : lista) {
            if (profesor.obtenerClave().equals(clave)) {
                lista.remove(profesor);
                return ResponseEntity.ok("Profesor eliminado con clave: " + clave);
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontró el profesor con clave: " + clave);
    }
    
}
