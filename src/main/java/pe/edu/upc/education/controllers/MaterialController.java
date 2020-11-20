package pe.edu.upc.education.controllers;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import pe.edu.upc.education.models.entities.Material;
import pe.edu.upc.education.models.entities.Sesion;
import pe.edu.upc.education.services.MaterialService;
import pe.edu.upc.education.services.SesionService;

@Controller
@RequestMapping("/materiales")
@SessionAttributes("material")
public class MaterialController {
	
	@Autowired
	private MaterialService materialService;
	
	@Autowired
	private SesionService sesionService;	
	
	@GetMapping("subir-material-{id}")
	public String crearMaterial(@PathVariable("id") Integer id, Model model) {
		Material material = new Material();
		try {
			Optional<Sesion> optional = sesionService.findById(id);
			material.setSesion(optional.get());
			model.addAttribute("material", material);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "/materiales/subir-material";
	}
	
	@PostMapping("guardar")	
	public String save(@ModelAttribute("material") Material material, SessionStatus status) {
		try {
			materialService.save(material);
			status.setComplete();
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		// Devuelve la URL mapping
		return "redirect:/sesiones/materiales-sesion-asesor-"+material.getSesion().getId();
	}
}
