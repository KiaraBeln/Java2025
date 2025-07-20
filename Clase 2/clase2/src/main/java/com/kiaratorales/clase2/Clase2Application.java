package com.kiaratorales.clase2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.kiaratorales.dto.OulookCorreo;
import com.kiaratorales.dto.SistemaCorreo;

@SpringBootApplication
public class Clase2Application {

	public static void main(String[] args) {
		SpringApplication.run(Clase2Application.class, args);
		
		SistemaCorreo sc = new OulookCorreo();
		sc.enviarCorreo("Kiarabeltorales@outlook.com");
		sc.adjuntarArchivo("archivo.txt");
		sc.eliminarMail(12345L);

	}

}