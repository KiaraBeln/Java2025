package com.kiaratorales.dto;

public class Profesor extends Persona {
    
    // Atributo específico de Profesor
 private Long codigoProfesor;

 public Long getCodigoProfesor() {
        return codigoProfesor;
    }
 public void setCodigoProfesor(Long codigoProfesor) {
       this.codigoProfesor = codigoProfesor;
    }
 public  void getCodigoProfesor(Long codigoProfesor) {
        this.codigoProfesor = codigoProfesor;
    }

 public Profesor(String nombre) {
        super(nombre);
    } 
public Profesor (){
        super();
    }

   
@Override
 public Long obtenerClave() {
        return this.codigoProfesor;
    }
}

