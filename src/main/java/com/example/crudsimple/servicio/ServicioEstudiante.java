package com.example.crudsimple.servicio;

import com.example.crudsimple.entidades.Estudiante;

import java.util.List;

public interface ServicioEstudiante {
    Estudiante guardarEstudiante(Estudiante estudiante);

    Estudiante obtenerEstudiante (Long idEstudiante);
    Estudiante modificarEstudiante(Long id,Estudiante estudianteModificar);
    boolean eliminarEstudiante(Long id);

    List<Estudiante> obtenerTodosLosEstudiantes();
}
