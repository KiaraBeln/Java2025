package com.kiaratorales.dto;

public class Alumno {
    private int matricula;
    private String nombre;
    private String apellido;

    public Alumno(int matricula, String nombre, String apellido) {
        this.matricula = matricula;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public int getMatricula() {
        return matricula;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }
}
