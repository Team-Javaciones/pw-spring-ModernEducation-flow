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

import pe.edu.upc.education.models.entities.Curso;
import pe.edu.upc.education.models.entities.Unidad;
import pe.edu.upc.education.services.CursoService;
import pe.edu.upc.education.services.UnidadService;

@Controller
@RequestMapping("/unidades")
@SessionAttributes("unidad")
public class UnidadController {
	@Autowired
	private UnidadService unidadService;

	@Autowired
	private CursoService cursoService;	
	
	@GetMapping("crear-unidad-{id}")
	public String crearUnidad(@PathVariable Integer id, Model model) {
		Unidad unidad = new Unidad();
		try {
			Optional<Curso> optional = cursoService.findById(id);
			unidad.setCurso(optional.get());
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
		return "redirect:/cursos/curso-view-asesor-"+unidad.getCurso().getId();
	}
	
	@GetMapping("unidad-view-asesor-{id}")
	public String unidadViewAsesor(@PathVariable("id") Integer id, Model model) {
		try {
			Optional<Unidad> optional = unidadService.findById(id);			
			model.addAttribute("unidad", optional.get());
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}	
		return "/unidades/unidad-view-asesor";
	}
	
	@GetMapping("unidad-view-alumno-{id}")
	public String unidadViewAlumno(@PathVariable("id") Integer id, Model model) {
		try {
			Optional<Unidad> optional = unidadService.findById(id);
			model.addAttribute("unidad", optional.get());
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}	
		return "/unidades/unidad-view-alumno";
	}
	
}
