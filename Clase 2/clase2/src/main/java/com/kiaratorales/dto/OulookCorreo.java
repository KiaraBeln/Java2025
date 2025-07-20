package com.kiaratorales.dto;

public class OulookCorreo implements SistemaCorreo {
    public OulookCorreo() {
        System.out.println("Instancia de OulookCorreo creada.");
    }

    @Override
    public String enviarCorreo(String destinatario) {
        // Implementación del envío de correo
        return "Correo enviado a: " + destinatario;
    }

    @Override
    public String adjuntarArchivo(String nombreArchivo) {
        System.out.println("Archivo adjuntado: " + nombreArchivo);
        return "OK";
    }

    @Override
    public void eliminarMail(Long id) {
        // Implementación de eliminación de correo
        System.out.println("Correo con ID " + id + " eliminado.");
    }

}
