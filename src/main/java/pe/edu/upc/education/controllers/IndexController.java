package pe.edu.upc.education.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class IndexController {

	@GetMapping
	public String indexAlumno() {		
		return "/alumnos/inicio-alumnos";
	}
	
	@GetMapping("inicio-asesores")
	public String indexAsesor() {		
		return "/asesores/inicio-asesores";
	}
}
