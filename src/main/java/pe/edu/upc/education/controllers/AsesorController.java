package pe.edu.upc.education.controllers;

import java.util.Optional;

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
	public String editarPerfil(Model model) {
		try {
			Optional<Asesor> optional = asesorService.findById(1);
			if(optional.isPresent()) {
			model.addAttribute("asesor", optional.get());
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "/asesores/perfil-asesor";
	}
	
	@PostMapping("update")	
	public String updatePerfil(@ModelAttribute("asesor") Asesor asesor, SessionStatus status) {
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
	
	
	
	@GetMapping("password-asesor")
	public String editarContra(Model model) {
			
		try {
			Optional<Asesor> optional = asesorService.findById(1);
			if(optional.isPresent()) {
			model.addAttribute("asesor", optional.get());
			}
			} 
			catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "/asesores/password-asesor";
	
	}
	
	@PostMapping("password")	
	public String updateContra(@ModelAttribute("asesor") Asesor asesor, SessionStatus status) {
		try {
			
			asesorService.update(asesor);
			status.setComplete();
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		// Devuelve la URL mapping
		return "redirect:/asesores/password-asesor";
	}
	
	
	
	
	
}
