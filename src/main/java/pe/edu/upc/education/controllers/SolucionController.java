package pe.edu.upc.education.controllers;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import pe.edu.upc.education.models.entities.Solucion;
import pe.edu.upc.education.services.SolucionService;

@Controller
@RequestMapping("/soluciones")
@SessionAttributes("solucion")
public class SolucionController {

	@Autowired
	private SolucionService solucionService;
	
	@GetMapping("enviar-solucion")
	public String enviarSolucion(Model model) {
		Solucion solucion = new Solucion();
		Date fechaActual = new Date();
		solucion.setFecha(fechaActual);
		try {
			model.addAttribute("solucion", solucion);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "/soluciones/enviar-solucion";
	}
	
	@PostMapping("save")	
	public String save(@ModelAttribute("solucion") Solucion solucion, SessionStatus status) {
		try {
			solucionService.save(solucion);
			status.setComplete();
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "redirect:/soluciones/enviar-solucion";
	}
}
