package pe.edu.upc.education.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class IndexController {

	@GetMapping
	public String index() {		
		return "/alumnos/inicio-alumnos";
	}
	
	/*
	@GetMapping("inicio-alumnos")
	public String indexAlumno() {		
		return "/alumnos/inicio-alumnos";
	}*/
	
	@GetMapping("inicio-asesores")
	public String indexAsesor() {		
		return "/asesores/inicio-asesores";
	}
	
	@RequestMapping("/default")
    public String defaultAfterLogin(HttpServletRequest request) {
        if (request.isUserInRole("ROLE_ALUMNO")) {
            return "redirect:/alumnos/";
        }
        return "redirect:/asesores/";
    }	
	
	/*
	@GetMapping("login1")
	public String login1(Model model) {	
		Usuario usuario = new Usuario();
		try {
			model.addAttribute("usuario", usuario);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "/alumnos/login-alumnos";
	}
	*/
	@GetMapping("login")
	public String login() {		
		return "login";
	}
	
	/*
	@PostMapping("comprobar")
	public String comprobar(Model model)
	{
		Usuario usuario = (Usuario)model.getAttribute("usuario");
		
		return "/alumnos/inicio-alumnos";
	}*/
}
