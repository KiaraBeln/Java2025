package com.kiaratorales.dto;

public class Alumno  extends Persona{
    private Long matricula;
   
    public Alumno() {
        super();
    }
    public Alumno(String nombre){
        setNombre(nombre);
    }
 // Constructor
    public Alumno(Long matricula, String nombre, String apellido) {
        this.matricula = matricula;
    
    }
// Getters and Setters
    public Long getMatricula() {
        return matricula;
    }
    public void setMatricula(Long matricula) {
        this.matricula = matricula;
    }
    
    @Override
    public Long obtenerClave() {
        return this.matricula;  
    }
}
