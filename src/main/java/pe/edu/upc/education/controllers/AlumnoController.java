package pe.edu.upc.education.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/alumnos")
public class AlumnoController {
		
	@GetMapping("login-alumnos")
	public String loginAlumno() {		
		return "/alumnos/login-alumnos";
	}
	
	@GetMapping("registro-alumnos")
	public String registroAlumno() {		
		return "/alumnos/registro-alumnos";
	}	
	
}

