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



import pe.edu.upc.education.models.entities.Alumno;
import pe.edu.upc.education.services.AlumnoService;

@Controller
@RequestMapping("/alumnos")
@SessionAttributes("alumno")
public class AlumnoController {
	
	@Autowired
	private AlumnoService alumnoService;
	
	
		
	@GetMapping("login-alumnos")
	public String loginAlumno() {		
		return "/alumnos/login-alumnos";
	}
	
	@GetMapping("registro-alumnos")
	public String registroAlumno() {		
		return "/alumnos/registro-alumnos";
	}	
	
	@GetMapping("perfil-alumno")
	public String editarPerifl(Model model) {
		Alumno alumno = new Alumno();
		alumno.setId(1);
		
		try {
			model.addAttribute("alumno", alumno);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "/alumnos/perfil-alumno";
	}
	
	@PostMapping("update")	
	public String save(@ModelAttribute("alumno") Alumno alumno, SessionStatus status) {
		try {
			alumnoService.update(alumno);
			status.setComplete();
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		// Devuelve la URL mapping
		return "redirect:/alumnos/perfil-alumno";
	}
}

