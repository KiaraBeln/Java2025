package com.kiaratorales.clase2.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kiaratorales.clase2.Model.Profesor;
import com.kiaratorales.clase2.repository.ProfesorRepository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.PutMapping;


// ...importaciones

@RestController
@RequestMapping("/profesor")
public class ProfesorRestController {

    private String claveSistema = "12345"; // Clave del sistema, se puede configurar en application.properties

    public List<Profesor> lista = new ArrayList<>();

    @Autowired 
    private ProfesorRepository repository;

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
    public ResponseEntity<?> listarProfesores() {
        List<Profesor> profesores = repository.findAll();
        if (profesores.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("No hay profesores registrados");
        } else {
            return ResponseEntity.ok(profesores);
        }
    }

    @PostMapping("/crear")
    public ResponseEntity<?> creaProfesor(@RequestBody Profesor profesor) {
   if (profesor == null || profesor.getNombre() == null || profesor.getApellido() == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Datos incompletos del profesor");
        }

        if (profesor.getCodigoProfesor() != null) {
            Profesor existente = repository.findById(profesor.getCodigoProfesor()).orElse(null);
            if (existente != null) {
                return ResponseEntity.status(HttpStatus.CONFLICT).body("El profesor ya existe con código: " + profesor.getCodigoProfesor());
            }
        }

        Profesor guardado = repository.save(profesor);
        return ResponseEntity.status(HttpStatus.CREATED).body("Profesor creado con éxito con código: " + guardado.getCodigoProfesor());
    }

        // Profesor profesorp = repository.save(profesor);
        /* for (Profesor aux : lista) {
            if (aux.obtenerClave().equals(profesor.obtenerClave())) {
                return ResponseEntity.status(HttpStatus.CONFLICT).body("El profesor ya existe");
            }
        }
        lista.add(profesor);
        */
    

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<?> actualizaProfesor(@RequestBody Profesor profesor, @PathVariable Long id) {
        if (id == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("El ID no puede ser nulo");
        } else if (!repository.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontró el profesor con ID: " + id);
        } else {
            profesor.setCodigoProfesor(id); // Asegura que el ID sea el correcto para actualizar
            repository.save(profesor);
            return ResponseEntity.ok("Profesor actualizado con éxito con ID: " + id);
        }

        /* for(Profesor aux: lista){
            if(aux.getCodigoProfesor().equals(id)) {
                aux.setNombre(profesor.getNombre());
                aux.setApellido(profesor.getApellido());
                aux.setCodigoProfesor(profesor.getCodigoProfesor());
                return ResponseEntity.ok("Profesor actualizado con éxito");
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontró el profesor con ID: " + id);
        */
    }

    @GetMapping("/obtener/{clave}")
    public ResponseEntity<?> getProfesor(@PathVariable Long clave) {
        if(clave == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("La clave no puede ser nula");
        }
        Profesor profesor = repository.findById(clave).orElse(null);
        if (profesor != null) {
            return ResponseEntity.ok(profesor);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontró el profesor con clave: " + clave);
        }

        // Si no se encuentra el profesor, se puede retornar un mensaje de error
        /* for (Profesor profesor : lista) {
            if (profesor.obtenerClave().equals(clave)) {
                return ResponseEntity.ok(profesor);
            }
        } */
        // return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontró el profesor con clave: " + clave); 
    }

    @DeleteMapping("/eliminar/{clave}")
    public ResponseEntity<?> eliminarProfesor(@PathVariable Long clave) {
        if(clave == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("La clave no puede ser nula");
        } else if(!repository.existsById(clave)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontró el profesor con clave: " + clave);
        } else {
            repository.deleteById(clave);
            return ResponseEntity.ok("Profesor eliminado con clave: " + clave);
        }

        /* for (Profesor profesor : lista) {
            if (profesor.obtenerClave().equals(clave)) {
                lista.remove(profesor);
                return ResponseEntity.ok("Profesor eliminado con clave: " + clave);
            }
        } */
        // return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontró el profesor con clave: " + clave);
    }

}