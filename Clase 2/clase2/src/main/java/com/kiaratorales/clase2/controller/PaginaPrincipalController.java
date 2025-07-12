package com.kiaratorales.clase2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class PaginaPrincipalController {
    @RequestMapping("")
    public String paginaPrincipal() {
        return "inicio"; // Retorna el nombre de la vista a mostrar
    }
}
