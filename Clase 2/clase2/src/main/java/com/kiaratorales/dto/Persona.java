package com.kiaratorales.dto;

public class Persona {

 private String nombre;
 private String apellido;

    public Persona() {
            // Constructor vacío
        }
    // Constructor
    public Persona(String nomrbe){
            this.nombre = nomrbe;
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
        return 0l;
    }
 }
