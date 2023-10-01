package com.example.crudsimple.controladores;

import com.example.crudsimple.entidades.Estudiante;
import com.example.crudsimple.repositorio.EstudianteRepository;
import com.example.crudsimple.servicio.ServicioEstudiante;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path = "/estudiantes")
@RequiredArgsConstructor
public class EstudianteController {
    @Autowired
    private EstudianteRepository estudianteRepository; // Debes crear esta interfaz y su implementación.
    private final ServicioEstudiante servicioEstudiante;
    // Mostrar la lista de estudiantes
    @GetMapping("/listar")
    public String listaEstudiantes(Model model) {
        List<Estudiante> estudiantes = estudianteRepository.findAll();
        model.addAttribute("estudiantes", estudiantes);
        return "listar";
    }

    // Mostrar el formulario para agregar un estudiante nuevo
    @GetMapping("/nuevo")
    public String formularioNuevoEstudiante(Model model) {
        model.addAttribute("estudiante", new Estudiante());
        return "formulario";
    }

    @PostMapping("/guardarEstudiante")
    public String guardarEstudiante(@ModelAttribute Estudiante estudiante) {
        if (estudiante.getId() == null) {
            servicioEstudiante.guardarEstudiante(estudiante);
        } else {
            servicioEstudiante.modificarEstudiante(estudiante.getId(), estudiante);
        }
        return "redirect:/estudiantes/listar";
    }

    // Procesar el formulario para agregar un estudiante nuevo
    @PostMapping("/nuevo")
    public String agregarEstudiante(@ModelAttribute Estudiante estudiante) {
        estudianteRepository.save(estudiante);
        return "redirect:/estudiantes/listar";
    }

    // Mostrar el formulario para editar un estudiante existente
    @GetMapping("/editar/{id}")
    public String formularioEditarEstudiante(@PathVariable Long id, Model model) {
        Estudiante estudiante = estudianteRepository.findById(id).orElse(null);
        if (estudiante == null) {
            return "redirect:/estudiantes/";
        }
        model.addAttribute("estudiante", estudiante);
        return "formulario";
    }

    // Procesar el formulario para editar un estudiante existente
    @PostMapping("/editar/{id}")
    public String editarEstudiante(@PathVariable Long id, @ModelAttribute Estudiante estudiante) {
        estudiante.setId(id);
        estudianteRepository.save(estudiante);
        return "redirect:/estudiantes/";
    }

    // Eliminar un estudiante
    @GetMapping("/eliminar/{id}")
    public String eliminarEstudiante(@PathVariable Long id) {
        estudianteRepository.deleteById(id);
        return "redirect:/estudiantes/listar";
    }
}

    /*private final ServicioEstudiante servicioEstudiante;
    @PostMapping
    public ResponseEntity guardarEstudiante(@RequestBody Estudiante estudiante){
        return new ResponseEntity(servicioEstudiante.guardarEstudiante(estudiante), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity obtenerEstudiante(@PathVariable("id") Long idEstudiante){
        return new ResponseEntity(servicioEstudiante.obtenerEstudiante(idEstudiante), HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity modificarEstudiante(@PathVariable("id") Long idEstudiante,@RequestBody Estudiante estudiante){
        return new ResponseEntity(servicioEstudiante.modificarEstudiante(idEstudiante, estudiante), HttpStatus.OK);
    }
    @DeleteMapping("/id")
    public ResponseEntity eliminarEstudiante(@PathVariable("id") Long idEstudiante){
        boolean respuesta = servicioEstudiante.eliminarEstudiante(idEstudiante);
        if (respuesta == true){
            return new ResponseEntity(HttpStatus.OK);
        }else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/listar")
    public ModelAndView listarEstudiantes() {
        ModelAndView modelAndView = new ModelAndView("estudiante/listar"); // Vista
        List<Estudiante> listaEstudiantes = servicioEstudiante.obtenerTodosLosEstudiantes(); // Obtener la lista de estudiantes desde el servicio
        modelAndView.addObject("estudiantes", listaEstudiantes); // Pasar la lista a la vista
        return modelAndView;
    }

    @GetMapping("/")
    public String listarEstudiantes(Model model) {
        model.addAttribute("estudiantes", estudianteRepository.findAll());
        return "estudiante/listar";
    }

    @GetMapping("/nuevo")
    public String mostrarFormularioNuevo(Model model) {
        model.addAttribute("estudiante", new Estudiante());
        return "estudiante/formulario";
    }

    @PostMapping("/guardar")
    public String guardarEstudiante(@ModelAttribute Estudiante estudiante) {
        estudianteRepository.save(estudiante);
        return "redirect:/estudiantes/";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable Long id, Model model) {
        Estudiante estudiante = estudianteRepository.findById(id).orElse(null);
        model.addAttribute("estudiante", estudiante);
        return "estudiante/formulario";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarEstudiante(@PathVariable Long id) {
        estudianteRepository.deleteById(id);
        return "redirect:/estudiantes/";
    }*/


