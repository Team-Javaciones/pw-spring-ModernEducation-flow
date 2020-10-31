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


import pe.edu.upc.education.models.entities.Asesor;
import pe.edu.upc.education.services.AsesorService;

@Controller
@RequestMapping("/asesores")
@SessionAttributes("asesor")
public class AsesorController {	
	
	@Autowired
	private AsesorService asesorService;
	
	@GetMapping("login-asesores")
	public String loginAsesor() {		
		return "/asesores/login-asesores";
	}
	
	@GetMapping("registro-asesores")
	public String registroAsesor() {		
		return "/asesores/registro-asesores";
	}
	
	
	@GetMapping("perfil-asesor")
	public String editarPerifl(Model model) {
		Asesor asesor = new Asesor();
		asesor.setId(1);
		
		
		try {
			model.addAttribute("asesor", asesor);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "/asesores/perfil-asesor";
	}
	
	@PostMapping("update")	
	public String save(@ModelAttribute("asesor") Asesor asesor, SessionStatus status) {
		try {
			asesorService.update(asesor);
			status.setComplete();
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		// Devuelve la URL mapping
		return "redirect:/asesores/perfil-asesor";
	}
	
}
