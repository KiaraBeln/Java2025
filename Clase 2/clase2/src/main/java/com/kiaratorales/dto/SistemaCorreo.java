package com.kiaratorales.dto;

public interface SistemaCorreo {
public String enviarCorreo(String destinatario);
public String adjuntarArchivo(String nombreArchivo);
public void eliminarMail(Long id);
}
