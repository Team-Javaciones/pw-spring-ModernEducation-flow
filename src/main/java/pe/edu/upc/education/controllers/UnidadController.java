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


import pe.edu.upc.education.models.entities.Unidad;
import pe.edu.upc.education.services.UnidadService;

@Controller
@RequestMapping("/unidades")
@SessionAttributes("unidad")
public class UnidadController {
	@Autowired
	private UnidadService unidadService;
	
	@GetMapping("crear-unidad")
	public String crearUnidad(Model model) {
		Unidad unidad = new Unidad();
		try {
			model.addAttribute("unidad", unidad);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "/unidades/crear-unidad";
	}
	
	@PostMapping("save")	
	public String save(@ModelAttribute("unidad") Unidad unidad, SessionStatus status) {
		try {
			unidadService.save(unidad);
			status.setComplete();
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		// Devuelve la URL mapping
		return "redirect:/unidades/crear-unidad";
	}
}
