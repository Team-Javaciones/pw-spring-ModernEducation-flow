package pe.edu.upc.education.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import pe.edu.upc.education.models.entities.Curso;
import pe.edu.upc.education.services.CursoService;

@Controller
@RequestMapping("/inicio-cursos")
@SessionAttributes("curso")
public class CursoController {

	@Autowired
	private CursoService cursoService;
	
	@GetMapping("/inicio-cursos")
	public String inicio(Model model) {
		
		Curso curso = new Curso();
		try {
			List<Curso> cursos = cursoService.findAll();
			model.addAttribute("cursos", cursos);
			model.addAttribute("curso", curso);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		
		return "/inicio-cursos";
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
		return "redirect:/inicio-cursos";
	}
}