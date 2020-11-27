package pe.edu.upc.education.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.edu.upc.education.models.entities.Alumno;
import pe.edu.upc.education.models.entities.Usuario;

@Controller
@RequestMapping("/")
public class IndexController {

	@GetMapping
	public String index() {		
		return "/alumnos/inicio-alumnos";
	}
	
	@GetMapping("inicio-alumnos")
	public String indexAlumno() {		
		return "/alumnos/inicio-alumnos";
	}
	
	@GetMapping("inicio-asesores")
	public String indexAsesor() {		
		return "/asesores/inicio-asesores";
	}
	@GetMapping("login")
	public String login(Model model) {	
		Usuario usuario = new Usuario();
		try {
			model.addAttribute("usuario", usuario);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "/alumnos/login-alumnos";
	}
	@PostMapping("comprobar")
	public String comprobar(Model model)
	{
		Usuario usuario = (Usuario)model.getAttribute("usuario");
		
		return "/alumnos/inicio-alumnos";
	}
}
