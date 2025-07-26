package com.kiaratorales.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Profesor  {
    @Id 
     // Atributo específico de Profesor
    @GeneratedValue(strategy=GenerationType.IDENTITY)     private Long codigoProfesor;
    private String nombre;
    private String apellido;
 public Long getCodigoProfesor() {
        return codigoProfesor;
    }
 public void setCodigoProfesor(Long codigoProfesor) {
       this.codigoProfesor = codigoProfesor;
    }
 public  void getCodigoProfesor(Long codigoProfesor) {
        this.codigoProfesor = codigoProfesor;
    }

    public String getNombre() {
        return nombre;
    }   
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Long obtenerClave() {
        return codigoProfesor; // Retorna el código del profesor como clave
    }   

    public Profesor() {
        // Constructor vacío
    }


}

