package pe.edu.upc.education.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import pe.edu.upc.education.models.entities.Ejercicio;
import pe.edu.upc.education.services.EjercicioService;

@Controller
@RequestMapping("/ejercicios")
@SessionAttributes("ejercicio")
public class EjercicioController {

	@Autowired
	private EjercicioService ejercicioService;
	
	@GetMapping("ejercicio-view-alumno-{id}")
	public String ejercicioViewAlumno(@PathVariable("id") Integer id, Model model) {	
		try {
			Optional<Ejercicio> optional = ejercicioService.findById(id);			
			model.addAttribute("ejercicio", optional.get());
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "/ejercicios/ejercicio-view-alumno";
	}	
}
