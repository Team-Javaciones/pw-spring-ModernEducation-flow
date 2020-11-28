package pe.edu.upc.education.controllers;

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
import pe.edu.upc.education.models.entities.AlumnoAsesor;
import pe.edu.upc.education.models.entities.Sesion;
import pe.edu.upc.education.models.entities.Unidad;
import pe.edu.upc.education.services.AlumnoAsesorService;
import pe.edu.upc.education.services.AlumnoService;
import pe.edu.upc.education.services.SesionService;
import pe.edu.upc.education.services.UnidadService;

@Controller
@RequestMapping("/sesiones")
@SessionAttributes("sesion")
public class SesionController {

	@Autowired
	private SesionService sesionService;

	@Autowired
	private AlumnoService alumnoService;
	
	@Autowired
	private UnidadService unidadService;
	
	@Autowired
	private AlumnoAsesorService alumnoAsesorService;

	@GetMapping("crear-sesion-{id}")
	public String crearSesion(@PathVariable("id") Integer id, Model model) {
		Sesion sesion = new Sesion();
		try {
			Optional<Unidad> optional = unidadService.findById(id);
			sesion.setUnidad(optional.get());

			model.addAttribute("sesion", sesion);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "/sesiones/crear-sesion";
	}
	@PostMapping("save")
	public String save(@ModelAttribute("sesion") Sesion sesion, SessionStatus status) {
		try {
			sesionService.save(sesion);
			status.setComplete();
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		// Devuelve la URL mapping
		return "redirect:/unidades/unidad-view-asesor-" + sesion.getUnidad().getId();
	}
	
	@GetMapping("sesion-alumno-{id}")
	public String menuSesionAlumno(@PathVariable("id") Integer id, Model model, Authentication authentication) {
		
		try {
			Optional<Alumno> alumno = alumnoService.findByUsername(authentication.getName());
			Optional<Sesion> sesion = sesionService.findById(id);			
			
			AlumnoAsesor alumnoAsesor = new AlumnoAsesor();
			alumnoAsesor.setAlumno(alumno.get());
			alumnoAsesor.setAsesor(sesion.get().getUnidad().getCurso().getAsesor());
			
			model.addAttribute("alumnoAsesor", alumnoAsesor);
			model.addAttribute("alumno", alumno.get());
			model.addAttribute("sesion", sesion.get());
			
			
			System.out.println("Sesion:  " + sesion.get().getTema());
			System.out.println("Alumno: " + alumno.get().getNombreCompleto());
			
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "/sesiones/sesion-alumno";
	}

	@PostMapping("saveAlumnoAsesor")
	public String saveAlumnoAsesor(@ModelAttribute("alumnoAsesor") AlumnoAsesor alumnoAsesor, @ModelAttribute("sesion") Sesion sesion, SessionStatus status, Authentication authentication) {
		try {
			Optional<Alumno> alumno = alumnoService.findByUsername(authentication.getName());
			alumnoAsesor.setAsesor(sesion.getUnidad().getCurso().getAsesor());
			alumnoAsesor.setAlumno(alumno.get());
			alumnoAsesorService.save(alumnoAsesor);
			status.setComplete();
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		// Devuelve la URL mapping
		return "redirect:/sesiones/sesion-alumno-" + sesion.getId();
	}

	@GetMapping("sesion-asesor-{id}")
	public String menuSesionAsesor(@PathVariable("id") Integer id, Model model) {
		try {
			Optional<Sesion> optional = sesionService.findById(id);
			model.addAttribute("sesion", optional.get());
		
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "/sesiones/sesion-asesor";
	}

	@GetMapping("materiales-sesion-alumno-{id}")
	public String materialesSesionAlumno(@PathVariable("id") Integer id, Model model) {
		try {
			Optional<Sesion> optional = sesionService.findById(id);
			model.addAttribute("sesion", optional.get());
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "/sesiones/materiales-sesion";
	}

	@GetMapping("materiales-sesion-asesor-{id}")
	public String materialesSesionAsesor(@PathVariable("id") Integer id, Model model) {
		try {
			Optional<Sesion> optional = sesionService.findById(id);
			model.addAttribute("sesion", optional.get());
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "/sesiones/materiales-sesion-asesor";
	}

	@GetMapping("ejercicios-sesion-alumno-{id}")
	public String ejerciciosSesionAlumno(@PathVariable("id") Integer id, Model model) {
		try {
			Optional<Sesion> optional = sesionService.findById(id);
			model.addAttribute("sesion", optional.get());
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "/sesiones/ejercicios-sesion-alumno";
	}

	@GetMapping("ejercicios-sesion-asesor-{id}")
	public String ejerciciosSesionAsesor(@PathVariable("id") Integer id, Model model) {
		try {
			Optional<Sesion> optional = sesionService.findById(id);
			model.addAttribute("sesion", optional.get());
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "/sesiones/ejercicios-sesion-asesor";
	}
	
	@GetMapping("editar-sesion-{id}")
	public String editarSesion(@PathVariable("id") Integer id, Model model) {
		try {
			Optional<Sesion> optional = sesionService.findById(id);
			if (optional.isPresent()) {
				model.addAttribute("sesion", optional.get());
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "/sesiones/editar-sesion";
	}

	@PostMapping("update")
	public String updateSesion(@ModelAttribute("sesion") Sesion sesion, SessionStatus status) {
		try {
			sesionService.update(sesion);
			status.setComplete();
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		// Devuelve la URL mapping
		return "redirect:/unidades/unidad-view-asesor-" + sesion.getUnidad().getId();
	}
	
}






