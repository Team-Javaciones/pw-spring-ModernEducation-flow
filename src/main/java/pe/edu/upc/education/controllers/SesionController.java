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
	
	@GetMapping
	public String menuSesion(Model model) {
		Sesion sesion = new Sesion();
		try {
			model.addAttribute("sesion", sesion);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "/sesiones/sesion";
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
	
	@GetMapping("materiales-sesion")
	public String materialesSesion(Model model){
		try {
			Optional<Sesion> optional = sesionService.findById(1);
			model.addAttribute("sesion", optional.get());					
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "/sesiones/materiales-sesion";
	}			
}
