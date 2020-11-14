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

import pe.edu.upc.education.models.entities.Asesor;
import pe.edu.upc.education.services.AsesorService;
import pe.edu.upc.education.services.SesionService;
import pe.edu.upc.education.models.entities.Ejercicio;
import pe.edu.upc.education.models.entities.Sesion;

@Controller
@RequestMapping("/asesores")
@SessionAttributes("asesor")
public class AsesorController {	
	
	@Autowired
	private AsesorService asesorService;
	
	@GetMapping("registro-asesores")
	public String registroAsesor() {		
		return "/asesores/registro-asesores";
	}
	
	
	@GetMapping("perfil-asesor")
	public String editarPerfil(Model model) {
		try {
			Optional<Asesor> optional = asesorService.findById(1);
			if(optional.isPresent()) {
			model.addAttribute("asesor", optional.get());
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "/asesores/perfil-asesor";
	}
	
	@PostMapping("update")	
	public String updatePerfil(@ModelAttribute("asesor") Asesor asesor, SessionStatus status) {
		try {
			asesorService.update(asesor);
			status.setComplete();
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		// Devuelve la URL mapping
		return "redirect:/asesores/perfil-asesor";
	}
	
	
	
	@GetMapping("password-asesor")
	public String editarContra(Model model) {
			
		try {
			Optional<Asesor> optional = asesorService.findById(1);
			if(optional.isPresent()) {
			model.addAttribute("asesor", optional.get());
			}
			} 
			catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "/asesores/password-asesor";
	
	}
	
	@PostMapping("password")	
	public String updateContra(@ModelAttribute("asesor") Asesor asesor, SessionStatus status) {
		try {
			
			asesorService.update(asesor);
			status.setComplete();
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		// Devuelve la URL mapping
		return "redirect:/asesores/password-asesor";
	}
	
	@GetMapping("login-asesores")
	public String LoginAsesor(Model model)
	{
		Asesor asesor=new Asesor();
		try {
			model.addAttribute("asesor", asesor);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		
		return "/asesores/login-asesores";
	}
	@PostMapping("comprobar")
	public String comprobarAsesor(@ModelAttribute("asesor") Asesor asesor ,SessionStatus status)
	{
		try {
			List<Asesor> optionalCorreo=asesorService.findByCorreoContaining(asesor.getCorreo());
			List<Asesor> optionalContraseña=asesorService.findByPasswordContaining(asesor.getPassword());
			if(!optionalCorreo.isEmpty() && !optionalContraseña.isEmpty()) {
				return "redirect:/inicio-asesores";
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "redirect:/asesores/login-asesores";
	}
	
	@GetMapping("buscar-asesor")
	public String buscarAsesor(Model model) {
		Asesor asesor = new Asesor();
		try {
			List<Asesor> asesores = asesorService.findAll();
			model.addAttribute("asesores", asesores);
			model.addAttribute("asesor", asesor);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "/asesores/buscador-asesor";
	}
	
	@GetMapping("cursos-asesor")
	public String cursosAsesor(Model model)
	{
		try {
			Optional<Asesor> optional = asesorService.findById(1);			
			model.addAttribute("asesor", optional.get());			
			
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "/asesores/cursos-asesor";
	}	
	
	@Autowired
	private SesionService sesionService;
	
	@GetMapping("crear-ejercicio")
	public String crearEjercicio( Integer id, Model model) {
		Ejercicio ejercicio = new Ejercicio();		
		try {
			List<Sesion> sesion = sesionService.findAll();
			model.addAttribute("sesion", sesion);	
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "/sesiones/crear-sesion";
	}
}
