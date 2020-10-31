package pe.edu.upc.education.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import pe.edu.upc.education.models.entities.Sesion;
import pe.edu.upc.education.services.SesionService;


@Controller
@RequestMapping("/sesiones")
@SessionAttributes("sesion")
public class SesionController {
	
	@Autowired
	private SesionService sesionService;
	
	@GetMapping("crear-sesion")
	public String crearSesion(Model model) {
		Sesion sesion = new Sesion();
		try {
			model.addAttribute("sesion", sesion);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "/sesiones/crear-sesion";
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
		return "redirect:/sesiones/crear-sesion";
	}
}
