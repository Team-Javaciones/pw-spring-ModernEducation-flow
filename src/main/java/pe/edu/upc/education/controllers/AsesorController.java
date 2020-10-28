package pe.edu.upc.education.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/asesores")
public class AsesorController {	
	
	@GetMapping("login-asesores")
	public String loginAsesor() {		
		return "/asesores/login-asesores";
	}
	
	@GetMapping("registro-asesores")
	public String registroAsesor() {		
		return "/asesores/registro-asesores";
	}
}
