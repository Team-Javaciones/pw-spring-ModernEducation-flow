package pe.edu.upc.education.controllers;


import java.util.List;
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

import pe.edu.upc.education.models.entities.Categoria;
import pe.edu.upc.education.models.entities.Curso;
import pe.edu.upc.education.services.CategoriaService;
import pe.edu.upc.education.services.CursoService;

@Controller
@RequestMapping("/cursos")
@SessionAttributes("curso")
public class CursoController {

	@Autowired
	private CursoService cursoService;
	
	@Autowired
	private CategoriaService categoriaService;
	
	@GetMapping
	public String inicio(Model model) {
		Curso curso = new Curso();
		
		try {
			List<Curso> cursos = cursoService.findAll();
			model.addAttribute("cursos", cursos);
			// Enviando el objeto curso para el nuevo elemento
			model.addAttribute("curso", curso);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		// Devuelve el nombre del archivo HTML
		return "/cursos/inicio-cursos";
	}
	
	@GetMapping("crear-curso")
	public String crearUnidad(Model model) {
		Curso curso = new Curso();
		try {
			List<Categoria> categorias = categoriaService.findAll();
			model.addAttribute("categorias",categorias);
			model.addAttribute("curso", curso);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "/cursos/crear-curso";
	}
	
	@GetMapping("buscar-curso")
	public String buscarCurso(Model model) {
		Curso curso = new Curso();
		try {
			List<Curso> cursos = cursoService.findAll();
			model.addAttribute("cursos", cursos);
			model.addAttribute("curso", curso);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "/cursos/buscador-curso";
	}
	
	@GetMapping("view-{id}")
	public String view(@PathVariable("id") Integer id, Model model) {
		try {
			Optional<Curso> optional = cursoService.findById(id);
			if(optional.isPresent()) {
				model.addAttribute("curso", optional.get());
				return "cursos/inicio-cursosView";
			} 
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "redirect:/cursos";		
	}
	
	@PostMapping("save")
	public String save(@ModelAttribute("curso") Curso curso, SessionStatus status) {
		try {
			
			
			cursoService.save(curso);
			status.setComplete();
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		// Devuelve la URL mapping 
		return "redirect:/cursos/crear-curso";
	}
	
	@GetMapping("calificar-curso")
	public String registroAsesor() {		
		return "/cursos/calificar-curso";
	}
	
	@GetMapping("recomendaciones-curso-alumno-{id}")
	public String recomendacionesViewAlumno(@PathVariable("id") Integer id, Model model) {		
		try {
			Optional<Curso> optional = cursoService.findById(id);
			if(optional.isPresent()){
				model.addAttribute("curso", optional.get());
				return "/cursos/recomendaciones-curso-alumno";
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}		
		return "";
	}
	
	@GetMapping("recomendaciones-curso-asesor-{id}")
	public String recomendacionesViewAsesor(@PathVariable("id") Integer id, Model model) {		
		try {
			Optional<Curso> optional = cursoService.findById(id);
			if(optional.isPresent()) {
				model.addAttribute("curso", optional.get());
				return "/cursos/recomendaciones-curso-asesor";
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}		
		return "";
	}
	
	@GetMapping("curso-view-alumno-{id}")
	public String cursoViewAlumno(@PathVariable("id") Integer id, Model model) {
		try {
			Optional<Curso> optional = cursoService.findById(id);
			if(optional.isPresent()) {
				model.addAttribute("curso", optional.get());
				return "/cursos/curso-view-alumno";
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}	
		return "redirect: /alumnos/cursos-alumno";
	}
	
	@GetMapping("curso-view-asesor-{id}")
	public String cursoViewAsesor(@PathVariable("id") Integer id, Model model) {
		try {
			Optional<Curso> optional = cursoService.findById(id);
			if(optional.isPresent()) {
				model.addAttribute("curso", optional.get());
				return "/cursos/curso-view-asesor";
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}	
		return "redirect: /asesores/cursos-asesor";
	}
	
}