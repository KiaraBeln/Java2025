package com.kiaratorales.dto;

public class Alumno {
    private Long matricula;
    private String nombre;
    private String apellido;
 // Constructor
    public Alumno(Long matricula, String nombre, String apellido) {
        this.matricula = matricula;
        this.nombre = nombre;
        this.apellido = apellido;
    }
// Getters and Setters
    public Long getMatricula() {
        return matricula;
    }
    public void setMatricula(Long matricula) {
        this.matricula = matricula;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }       
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }
}
