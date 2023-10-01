package com.example.crudsimple.repositorio;

import com.example.crudsimple.entidades.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstudianteRepository extends JpaRepository<Estudiante, Long> {
    //Estudiante findByNombre(String nombre);

    //@Query("select u from Estudiante u where u.matricula = ?1")
    //Estudiante consultaEstudiante(String matricula);
}