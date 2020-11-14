package pe.edu.upc.education.controllers;

import java.util.List;
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
import pe.edu.upc.education.models.entities.Unidad;
import pe.edu.upc.education.services.SesionService;
import pe.edu.upc.education.services.UnidadService;


@Controller
@RequestMapping("/sesiones")
@SessionAttributes("sesion")
public class SesionController {
	
	@Autowired
	private SesionService sesionService;
	
	@Autowired
	private UnidadService unidadService;
	
	@GetMapping("crear-sesion-{id}")
	public String crearSesion(@PathVariable("id") Integer id, Model model) {
		Sesion sesion = new Sesion();		
		try {
			Optional<Unidad> optional = unidadService.findById(id);
			sesion.setUnidad(optional.get());
			
			model.addAttribute("sesion", sesion);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "/sesiones/crear-sesion";
	}
	
	@GetMapping("sesion-alumno-{id}")
	public String menuSesionAlumno(@PathVariable("id") Integer id, Model model) {
		try {
			Optional<Sesion> optional = sesionService.findById(id);
			model.addAttribute("sesion", optional.get());
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "/sesiones/sesion-alumno";
	}
	
	@GetMapping("sesion-asesor-{id}")
	public String menuSesionAsesor(@PathVariable("id") Integer id, Model model) {
		try {
			Optional<Sesion> optional = sesionService.findById(id);
			model.addAttribute("sesion", optional.get());
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "/sesiones/sesion-asesor";
	}
	
	@PostMapping("save")	
	public String save(@ModelAttribute("sesion") Sesion sesion, SessionStatus status) {
		try {
			sesionService.save(sesion);
			status.setComplete();
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		// Devuelve la URL mapping
		return "redirect:/unidades/unidad-view-asesor-" + sesion.getUnidad().getId();
	}
	
	@GetMapping("materiales-sesion-{id}")
	public String materialesSesion(@PathVariable("id") Integer id, Model model){
		try {
			Optional<Sesion> optional = sesionService.findById(id);
			model.addAttribute("sesion", optional.get());					
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "/sesiones/materiales-sesion";
	}		
	
	@GetMapping("ejercicios-sesion-{id}")
	public String ejerciciosSesion(@PathVariable("id") Integer id, Model model){
		try {
			Optional<Sesion> optional = sesionService.findById(id);
			model.addAttribute("sesion", optional.get());					
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "/sesiones/ejercicios-sesion";
	}	
	
	
	@GetMapping("crear-ejercicio")
	public String crearEjercicio( Model model) {
		Ejercicio ejercicio = new Ejercicio();		
		try {
			List<Sesion> sesion = sesionService.findAll();
			model.addAttribute("sesion", sesion);	
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "/sesiones/crear-ejercicio";
	}
}
