package pe.edu.upc.education.controllers;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import pe.edu.upc.education.models.entities.Alumno;
import pe.edu.upc.education.models.entities.Ejercicio;
import pe.edu.upc.education.models.entities.Solucion;
import pe.edu.upc.education.services.AlumnoService;
import pe.edu.upc.education.services.EjercicioService;
import pe.edu.upc.education.services.SolucionService;

@Controller
@RequestMapping("/soluciones")
@SessionAttributes("solucion")
public class SolucionController {

	@Autowired
	private SolucionService solucionService;
	
	@Autowired
	private EjercicioService ejercicioService;
	
	@Autowired
	private AlumnoService alumnoService;
	
	@GetMapping("enviar-solucion-{id}")
	public String enviarSolucion(@PathVariable("id") Integer id, Model model,  Authentication authentication) {
		Solucion solucion = new Solucion();
		Date fechaActual = new Date();
		solucion.setFecha(fechaActual);		
		try {
			Optional<Alumno> optional1 = alumnoService.findByUsername(authentication.getName());
			solucion.setAlumno(optional1.get());
			Optional<Ejercicio> optional2 = ejercicioService.findById(id); 
			solucion.setEjercicio(optional2.get());
			model.addAttribute("solucion", solucion);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "/soluciones/enviar-solucion";
	}
	
	@PostMapping("save")	
	public String save(@ModelAttribute("solucion") Solucion solucion, SessionStatus status) {
		try {
			solucionService.save(solucion);
			status.setComplete();
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "redirect:/ejercicios/ejercicio-view-alumno-" + solucion.getEjercicio().getId();
	}
}
