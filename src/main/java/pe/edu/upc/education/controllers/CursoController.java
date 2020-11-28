package pe.edu.upc.education.controllers;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import pe.edu.upc.education.models.entities.Alumno;
import pe.edu.upc.education.models.entities.AlumnoCurso;
import pe.edu.upc.education.models.entities.Asesor;
import pe.edu.upc.education.models.entities.Categoria;
import pe.edu.upc.education.models.entities.Curso;
import pe.edu.upc.education.services.AlumnoService;
import pe.edu.upc.education.services.AsesorService;
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
	
	@Autowired
	private AsesorService asesorService;

	@Autowired
	private AlumnoService alumnoService;
	
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
	public String crearCurso(Model model, Authentication authentication) {
		Curso curso = new Curso();
		try {
			Optional<Asesor> op = asesorService.findByUsername(authentication.getName());
			curso.setAsesor(op.get());
			model.addAttribute("curso", curso);
			
			List<Categoria> categorias = categoriaService.findAll();
			model.addAttribute("categorias",categorias);			
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "/cursos/crear-curso";
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
		return "redirect:/asesores/cursos-asesor";
	}
	
	@GetMapping("buscar-curso")
	public String buscarCurso(Model model) {
		Curso curso = new Curso();
		Curso cursoSearch = new Curso();
		try {
			List<Curso> cursos = cursoService.findAll();

			model.addAttribute("cursoSearch", cursoSearch);
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
	
	
	
	@GetMapping("calificar-curso-{cursoID}")
	public String calificarCurso(@PathVariable("cursoID") Integer id, Model model, Authentication authentication) {

		try
		{	
			Optional<Alumno> alumno = alumnoService.findByUsername(authentication.getName());
			Optional<Curso> curso = cursoService.findById(id);
		
			AlumnoCurso alumno_curso = new AlumnoCurso();
			alumno_curso.setAlumno(alumno.get());
			alumno_curso.setCurso(curso.get());

			model.addAttribute("alumno_curso", alumno_curso);
			model.addAttribute("alumno", alumno.get());
			model.addAttribute("curso", curso.get());
			
			System.out.println(curso.get().getNombre());
		
			return "/cursos/calificar-curso";
		}
		catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}		
		return "/inicio-asesores";
	}
	@PostMapping()
	public String calificar(@ModelAttribute("alumno_curso") AlumnoCurso alumno_curso, Model model)
	{

		return "/inicio-asesores";
	}
	
	
	@GetMapping("recomendaciones-curso-alumno-{id}")
	public String recomendacionesViewAlumno(@PathVariable("id") Integer id, Model model) {		
		try {
			Optional<Curso> optional = cursoService.findById(id);
			model.addAttribute("curso", optional.get());
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}		
		return "/cursos/recomendaciones-curso-alumno";
	}
	
	@GetMapping("recomendaciones-curso-asesor-{id}")
	public String recomendacionesViewAsesor(@PathVariable("id") Integer id, Model model) {		
		try {
			Optional<Curso> optional = cursoService.findById(id);
			model.addAttribute("curso", optional.get());
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}		
		return "/cursos/recomendaciones-curso-asesor";
	}
	
	@GetMapping("curso-view-alumno-{id}")
	public String cursoViewAlumno(@PathVariable("id") Integer id, Model model) {
		try {
			Optional<Curso> optional = cursoService.findById(id);
			model.addAttribute("curso", optional.get());
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}	
		return "/cursos/curso-view-alumno";
	}
	
	@GetMapping("curso-view-asesor-{id}")
	public String cursoViewAsesor(@PathVariable("id") Integer id, Model model) {
		try {
			Optional<Curso> optional = cursoService.findById(id);
			model.addAttribute("curso", optional.get());
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}	
		return "/cursos/curso-view-asesor";
	}
	
	@PostMapping("search-curso")
	public String search(@ModelAttribute("cursoSearch") Curso cursoSearch, Model model) {
		model.addAttribute("cursoSearch", cursoSearch);
		try {
			List<Curso> cursos = cursoService.findByNombre(cursoSearch.getNombre());
			model.addAttribute("cursos", cursos);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "/cursos/buscador-curso";
	}
	
	@PostMapping("search-precio")
	public String searchPrecio(@ModelAttribute("cursoSearch") Curso cursoSearch, Model model) {
		model.addAttribute("cursoSearch", cursoSearch);
		try {
			List<Curso> cursos = cursoService.findByPrecio(cursoSearch.getPrecio());
			model.addAttribute("cursos", cursos);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "/cursos/buscador-curso";
	}
	
	@PostMapping("search-valoracion")
	public String searchValoracion(@ModelAttribute("cursoSearch") Curso cursoSearch, Model model) {
		model.addAttribute("cursoSearch", cursoSearch);
		try {
			List<Curso> cursos = cursoService.findByPopularidad(cursoSearch.getPopularidad());
			model.addAttribute("cursos", cursos);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "/cursos/buscador-curso";
	}
	
}