package com.example.crudsimple.servicio;

import com.example.crudsimple.entidades.Estudiante;
import com.example.crudsimple.repositorio.EstudianteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ServicioEstudianteImpl implements ServicioEstudiante {

    private final EstudianteRepository estudianteRepository;
    @Override
    public Estudiante guardarEstudiante(Estudiante estudiante) {
        return estudianteRepository.save(estudiante);
    }

    @Override
    public Estudiante obtenerEstudiante(Long idEstudiante) {
        return estudianteRepository.findById(idEstudiante).orElseThrow(() -> {throw new RuntimeException();});
    }

    @Override
    public Estudiante modificarEstudiante(Long id, Estudiante estudianteModificar) {
        Estudiante estudianteBuscado = estudianteRepository.findById(id).get();
        estudianteBuscado.setNombre(estudianteModificar.getNombre());
        estudianteBuscado.setTelefono(estudianteModificar.getTelefono());
        return estudianteRepository.save(estudianteBuscado);
    }

    @Override
    public boolean eliminarEstudiante(Long id) {
        try {
            estudianteRepository.deleteById(id);
            return true;
        }catch (Exception e){
            return false;
        }

    }

    public List<Estudiante> obtenerTodosLosEstudiantes() {
        return estudianteRepository.findAll();
    }
}

