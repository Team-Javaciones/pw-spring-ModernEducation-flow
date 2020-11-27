package pe.edu.upc.education.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import pe.edu.upc.education.models.entities.Alumno;
import pe.edu.upc.education.models.entities.Usuario;
import pe.edu.upc.education.services.AlumnoService;
import pe.edu.upc.education.services.UsuarioService;

@Controller
@RequestMapping("/alumnos")
@SessionAttributes("alumno")
public class AlumnoController {

	@Autowired
	private AlumnoService alumnoService;
	
	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping("registro-alumnos")
	public String registroAlumno(Model model) {
		Alumno alumno = new Alumno();
		model.addAttribute("alumno", alumno);
		Usuario usuario = new Usuario();
		model.addAttribute("usuario", usuario);
		
		return "/alumnos/registro-alumnos";
	}
	@PostMapping("registrar")
	public String registrarAlumno(@ModelAttribute("alumno") Alumno alumno, @ModelAttribute("usuario") Usuario usuario, SessionStatus status)
	{
		try {
			usuario.setPassword(new BCryptPasswordEncoder().encode(usuario.getPassword()));
			usuario.setTipo("ALUMNO");
			usuario.setEnable(true);
			usuario.addAuthority("ROLE_ALUMNO");
			alumnoService.save(alumno);
			usuarioService.save(usuario);
			status.setComplete();
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		
		return "redirect:/login";
	}
	/*
	@GetMapping("login-alumnos")
	public String loginAlumno(Model model) {
		Usuario usuario = new Usuario();
		model.addAttribute("usuario", usuario);
		
		return "/alumnos/login-alumnos";
	}*/
	/*
	@PostMapping("login")
	public String loginAsesor(@ModelAttribute("usuario") Usuario usuario, SessionStatus status)
	{
		try {
			//Valida solo en usuario
			//Fata la contraseña
			Optional<Alumno> alumno = alumnoService.findByUsername(usuario.getUsername());
			
			if (!alumno.isEmpty())
			{
				
				return "redirect:/alumnos/perfil-alumno";
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		
		return "redirect:/alumnos/ingreso-alumnos";
	}
	*/
	@GetMapping("perfil-alumno")
	public String editarPerfil(Model model, Authentication authentication) {

		try {
			Optional<Alumno> optional = alumnoService.findByUsername(authentication.getName());
			if (optional.isPresent()) {
				model.addAttribute("alumno", optional.get());
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "/alumnos/perfil-alumno";
	}

	@PostMapping("update")
	public String updatePerfil(@ModelAttribute("alumno") Alumno alumno, SessionStatus status) {
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

	@GetMapping("password-alumno")
	public String editarContra(Model model, Authentication authentication) {
		try {
			Optional<Alumno> optional = alumnoService.findByUsername(authentication.getName());
			if (optional.isPresent()) {
				model.addAttribute("alumno", optional.get());
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "/alumnos/password-alumno";

	}
	@PostMapping("password")
	public String updateContra(@ModelAttribute("alumno") Alumno alumno, SessionStatus status) {
		try {
			alumnoService.update(alumno);
			status.setComplete();
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		// Devuelve la URL mapping
		return "redirect:/alumnos/password-alumno";
	}

	@GetMapping
	public String menuAlumno(Model model, Authentication authentication) {
		try {			
			Optional<Alumno> optional = alumnoService.findByUsername(authentication.getName());			
			model.addAttribute("alumno", optional.get());	
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "/alumnos/menu-alumnos";
	}	

	@GetMapping("cursos-alumno")
	public String cursosAlumno(Model model, Authentication authentication)
	{
		try {
			Optional<Alumno> optional = alumnoService.findByUsername(authentication.getName());		
			model.addAttribute("alumno", optional.get());			
			
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "/alumnos/cursos-alumno";
	}
	
	@GetMapping("olvida-contra")
	public String olvidoContra(Model model) {
		Alumno alumno = new Alumno();
		try {
			model.addAttribute("alumno", alumno);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "/alumnos/olvida-contra";
	}
}
