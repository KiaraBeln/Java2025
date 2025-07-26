package com.kiaratorales.clase2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kiaratorales.dto.Profesor;

public interface ProfesorRepository extends JpaRepository<Profesor, Long> {
    // Aquí puedes definir métodos personalizados si es necesario
    // Por ejemplo, buscar por nombre, etc.
    

}
