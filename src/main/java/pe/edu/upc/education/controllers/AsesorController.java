package pe.edu.upc.education.controllers;

import java.util.List;
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

import pe.edu.upc.education.models.entities.Asesor;
import pe.edu.upc.education.services.AsesorService;
import pe.edu.upc.education.services.UsuarioService;
import pe.edu.upc.education.models.entities.Usuario;

@Controller
@RequestMapping("/asesores")
@SessionAttributes("asesor")
public class AsesorController {	

	@Autowired
	private AsesorService asesorService;

	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping("registro-asesores")
	public String registroAsesor(Model model) {
		Asesor asesor = new Asesor();
		model.addAttribute("asesor", asesor);
		Usuario usuario = new Usuario();
		model.addAttribute("usuario", usuario);
		
		return "/asesores/registro-asesores";
	}
	@PostMapping("registrar")
	public String registrarAsesor(@ModelAttribute("asesor") Asesor asesor ,@ModelAttribute("usuario") Usuario usuario ,SessionStatus status)
	{
		try {
			usuario.setPassword(new BCryptPasswordEncoder().encode(usuario.getPassword()));
			usuario.setTipo("ASESOR");
			usuario.setEnable(true);
			usuario.addAuthority("ROLE_ASESOR");
			asesorService.save(asesor);
			usuarioService.save(usuario);
			status.setComplete();
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		
		return "redirect:/login";
	}
	
	/*
	@GetMapping("login-asesores")
	public String loginAsesores(Model model) {
		Usuario usuario = new Usuario();
		model.addAttribute("usuario", usuario);
		
		return "/asesores/login-asesores";
	}
	@PostMapping("login")
	public String loginAsesor(@ModelAttribute("usuario") Usuario usuario, SessionStatus status)
	{
		try {
			//Valida solo en usuario
			//Fata la contraseña
			Optional<Asesor> asesor = asesorService.findByUsername(usuario.getUsername());
			
			if (!asesor.isEmpty())
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
	
	@GetMapping("perfil-asesor")
	public String perfilAsesor(Model model, Authentication authentication) {
		try {
			Optional<Asesor> optional = asesorService.findByUsername(authentication.getName());
			if(optional.isPresent()) {
			model.addAttribute("asesor", optional.get());
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "/asesores/perfil-asesor";
	}		
	@GetMapping("editar-perfil-asesor")
	public String editarPerfil(Model model, Authentication authentication) {
		try {
			Optional<Asesor> optional = asesorService.findByUsername(authentication.getName());
			if(optional.isPresent()) {
			model.addAttribute("asesor", optional.get());
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "/asesores/editar-perfil-asesor";
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
	public String editarContra(Model model, Authentication authentication) {			
		try {
			Optional<Asesor> optional = asesorService.findByUsername(authentication.getName());
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
	
	
	@GetMapping("buscar-asesor")
	public String buscarAsesor(Model model) {
		Asesor asesor = new Asesor();
		Asesor asesorSearch = new Asesor();
		try {
			List<Asesor> asesores = asesorService.findAll();
			model.addAttribute("asesorSearch", asesorSearch);
			model.addAttribute("asesores", asesores);
			model.addAttribute("asesor", asesor);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "/asesores/buscador-asesor";
	}
	
	@GetMapping
	public String menuAsesor(Model model, Authentication authentication) {		
		try {			
			Optional<Asesor> optional = asesorService.findByUsername(authentication.getName());			
			model.addAttribute("asesor", optional.get());	
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "/asesores/menu-asesores";
	}	
	
	@GetMapping("cursos-asesor")
	public String cursosAsesor(Model model, Authentication authentication)
	{
		try {
			Optional<Asesor> optional = asesorService.findByUsername(authentication.getName());			
			model.addAttribute("asesor", optional.get());			
			
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "/asesores/cursos-asesor";
	}
	
	@PostMapping("search-asesor")
	public String searchAsesor(@ModelAttribute("asesorSearch") Asesor asesorSearch, Model model) {
		model.addAttribute("asesorSearch", asesorSearch);
		try {
			List<Asesor> asesores = asesorService.findByNombreCompleto(asesorSearch.getNombreCompleto()); 
			model.addAttribute("asesores", asesores);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "/asesores/buscador-asesor";
	}
	

}
