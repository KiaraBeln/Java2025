package com.kiaratorales.clase2.controller;

import org.springframework.stereotype.Controller;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.kiaratorales.dto.Alumno;

@Controller
@RequestMapping("/alumno")
public class AlumnoController {
    @RequestMapping("listar")
    public String listarAlumno(Model model) {
        
        System.out.println("Listando alumnos");

        Alumno alumno1, alumno2, alumno3, alumno4;

        alumno1 = new Alumno(2020100292, "Juan", "Pérez");
        alumno2 = new Alumno(2020100293, "Ana", "Gómez");
        alumno3 = new Alumno(2020100294, "Luis", "Martínez");
        alumno4 = new Alumno(2020100295, "María", "López");
       // Alumno[] alumnos = {alumno1, alumno2, alumno3, alumno4};
       /*
        for (Alumno item : alumnos) {
            System.out.println("Matricula: " + item.matricula + ", Nombre: " + item.nombre + ", Apellido: "
             + item.apellido);
        }
        */

       List<Alumno> listado = new ArrayList<>();
        listado.add(alumno1);
        listado.add(alumno2);
        listado.add(alumno3);
        listado.add(alumno4);
        
        ///trenmap lo hace en orden de inserción
        //LinkedHashMap<String, Alumno> mapa = new LinkedHashMap<>(); lo hace en orden alfabético
        //HashMap no garantiza el orden de inserción
        Map<String, Alumno> mapa = new HashMap<>();
        mapa.put("2020100292", alumno1);
        mapa.put("2020100293", alumno2);
        mapa.put("2020100294", alumno3);
        mapa.put("2020100295", alumno4);
        
        for(String key : mapa.keySet()) {
            System.out.println("Matricula: " + key +
             ", Alumno: " + mapa.get(key).getApellido() + " " + mapa.get(key).getApellido());
         }
        //es mas efectivo desde este manera
         System.out.println("Recorriendo el mapa:");
         // Recorriendo el mapa con entrySet()
        for (Map.Entry<String, Alumno> entry : mapa.entrySet()) {
            System.out.println("Matricula: " + entry.getKey() +
             ", Alumno: " + entry.getValue().getNombre() + " " + entry.getValue().getApellido());
         }
        

        model.addAttribute( "mensaje", "Listado de alumnos" );
        model.addAttribute("listado", listado);
        model.addAttribute("mejorAlumno", alumno1.getNombre());
        return "alumno/listar";//Llama a la vista listarAlumno.html
    }
    
}
