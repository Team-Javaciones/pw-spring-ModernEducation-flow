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
import pe.edu.upc.education.models.entities.Asesor;
import pe.edu.upc.education.models.entities.Usuario;
import pe.edu.upc.education.services.AlumnoService;
import pe.edu.upc.education.services.AsesorService;
import pe.edu.upc.education.services.UsuarioService;

@Controller
@RequestMapping("/alumnos")
@SessionAttributes("alumno")
public class AlumnoController {

	@Autowired
	private AlumnoService alumnoService;
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private AsesorService asesorService;
	
	
	
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
	
	@GetMapping("perfil-alumno")
	public String perfilAlumno(Model model, Authentication authentication) {
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
	@GetMapping("editar-perfil-alumno")
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
		return "/alumnos/editar-perfil-alumno";
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
			Usuario usuario = new Usuario();
			if (optional.isPresent()) {
				model.addAttribute("alumno", optional.get());
				model.addAttribute("usuario", usuario);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "/alumnos/password-alumno";

	}
	@PostMapping("password")
	public String updateContra(@ModelAttribute("alumno") Alumno alumno, @ModelAttribute("usuario") Usuario usuario, SessionStatus status) {
		try {
			Optional<Alumno> optionalA = alumnoService.findByCorreo(alumno.getCorreo());
			
			if (optionalA.isPresent()) {

				Optional<Usuario> optionalU = usuarioService.findByUsername(optionalA.get().getUsername());

				optionalU.get().setPassword(new BCryptPasswordEncoder().encode(usuario.getPassword()));

				alumnoService.update(optionalA.get());
				usuarioService.update(optionalU.get());
			}
			

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
	
	
	
	@GetMapping("asesores")  //esta relacionado a cambiarContra
	public String olvidoContra(Model model) {
		Alumno alumno = new Alumno();
		model.addAttribute("alumno", alumno);
		Usuario usuario = new Usuario();
		model.addAttribute("usuario", usuario);

		return "/olvida-contra";
	}
	
	@PostMapping("cambiarContra")
	public String cambiarContra(@ModelAttribute("alumno") Alumno alumno, @ModelAttribute("usuario") Usuario usuario, SessionStatus status) {
		
		//System.out.println("nombre de la cuenta:" + alumno.getCorreo());
		try {
			Optional<Alumno> optionalA = alumnoService.findByCorreo(alumno.getCorreo());
			Optional<Asesor> optionalASE= asesorService.findByCorreo(alumno.getCorreo());
			if (optionalA.isPresent()) {

				Optional<Usuario> optionalU = usuarioService.findByUsername(optionalA.get().getUsername());

				optionalU.get().setPassword(new BCryptPasswordEncoder().encode(usuario.getPassword()));

				alumnoService.update(optionalA.get());
				usuarioService.update(optionalU.get());
			}
			if(optionalASE.isPresent())
			{
				Optional<Usuario> optionalU = usuarioService.findByUsername(optionalASE.get().getUsername());

				optionalU.get().setPassword(new BCryptPasswordEncoder().encode(usuario.getPassword()));
				
				asesorService.update(optionalASE.get());
				usuarioService.update(optionalU.get());
			}

			status.setComplete();
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		
		
		return "redirect:/login";
	}

}
