package pe.edu.upc.education.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import pe.edu.upc.education.models.entities.Ejercicio;
import pe.edu.upc.education.models.entities.Sesion;
import pe.edu.upc.education.services.EjercicioService;
import pe.edu.upc.education.services.SesionService;

@Controller
@RequestMapping("/ejercicios")
@SessionAttributes("ejercicio")
public class EjercicioController {

	@Autowired
	private EjercicioService ejercicioService;	
	
	@Autowired
	private SesionService sesionService;	
	
	@GetMapping("crear-ejercicio-{id}")
	public String crearEjercicio(@PathVariable("id") Integer id, Model model) {
		Ejercicio ejercicio = new Ejercicio();		
		try {
			Optional<Sesion> optional = sesionService.findById(id);
			ejercicio.setSesion(optional.get());
			
			model.addAttribute("ejercicio", ejercicio);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "/ejercicios/crear-ejercicio";
	}
	
	@PostMapping("save")	
	public String save(@ModelAttribute("ejercicio") Ejercicio ejercicio, SessionStatus status) {
		try {
			ejercicioService.save(ejercicio);
			status.setComplete();
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		// Devuelve la URL mapping
		return "redirect:/sesiones/ejercicios-sesion-asesor-" + ejercicio.getSesion().getId();
	}	
	
	@GetMapping("ejercicio-view-alumno-{id}")
	public String ejercicioViewAlumno(@PathVariable("id") Integer id, Model model) {	
		try {
			Optional<Ejercicio> optional = ejercicioService.findById(id);			
			model.addAttribute("ejercicio", optional.get());
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "/ejercicios/ejercicio-view-alumno";
	}	
	
	@GetMapping("ejercicio-view-asesor-{id}")
	public String ejercicioViewAsesor(@PathVariable("id") Integer id, Model model) {	
		try {
			Optional<Ejercicio> optional = ejercicioService.findById(id);			
			model.addAttribute("ejercicio", optional.get());
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "/ejercicios/ejercicio-view-asesor";
	}	
}
