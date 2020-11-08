package pe.edu.upc.education.controllers;

import java.util.List;
import java.util.Optional;

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
import pe.edu.upc.education.models.entities.Sesion;
import pe.edu.upc.education.services.AlumnoService;

@Controller
@RequestMapping("/alumnos")
@SessionAttributes("alumno")
public class AlumnoController {

	@Autowired
	private AlumnoService alumnoService;

	@GetMapping("registro-alumnos")
	public String registroAlumno() {
		return "/alumnos/registro-alumnos";
	}

	@GetMapping("perfil-alumno")
	public String editarPerfil(Model model) {

		try {
			Optional<Alumno> optional = alumnoService.findById(1);
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
	public String editarContra(Model model) {

		try {
			Optional<Alumno> optional = alumnoService.findById(1);
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

	@GetMapping("login-alumnos")
	public String LoginAlumno(Model model) {
		Alumno alumno = new Alumno();
		try {
			model.addAttribute("alumno", alumno);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "/alumnos/login-alumnos";
	}

	@PostMapping("comprobar")
	public String comprobarAlumno(@ModelAttribute("alumno") Alumno alumno, SessionStatus status) {
		try {
			List<Alumno> optionalCorreo = alumnoService.findByCorreoContaining(alumno.getCorreo());
			List<Alumno> optionalContraseña = alumnoService.findByPasswordContaining(alumno.getPassword());
			if (!optionalCorreo.isEmpty() && !optionalContraseña.isEmpty()) {
				return "redirect:/inicio-alumnos";
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		// Devuelve la URL mapping
		return "redirect:/alumnos/login-alumnos";
	}

	@GetMapping
	public String menuAlumno(Model model) {
		Alumno alumno = new Alumno();
		try {
			model.addAttribute("alumno", alumno);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "/alumnos/menu-alumnos";
	}

}
