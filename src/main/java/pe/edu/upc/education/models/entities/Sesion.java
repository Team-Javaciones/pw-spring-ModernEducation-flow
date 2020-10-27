package pe.edu.upc.education.models.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "sesiones")
public class Sesion {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "tema", length = 100, nullable = false)
	private String tema;
	
	@Column(name = "link_zoom", length = 250, nullable = false)
	private String linkZoom;
	
	@Column(name = "link_grabacion", length = 250, nullable = true)
	private String linkGrabacion;
	
	@OneToMany(mappedBy = "sesion")
	private List<Material> materiales;
	
	@ManyToOne
	@JoinColumn(name = "unidad_id")
	private Unidad unidad;
		
	@OneToMany(mappedBy = "sesion")
	private List<Ejercicio> ejercicios;
	
	public Sesion() {
		materiales = new ArrayList<Material>();
		ejercicios = new ArrayList<Ejercicio>();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTema() {
		return tema;
	}

	public void setTema(String tema) {
		this.tema = tema;
	}

	public String getLinkZoom() {
		return linkZoom;
	}

	public void setLinkZoom(String linkZoom) {
		this.linkZoom = linkZoom;
	}

	public String getLinkGrabacion() {
		return linkGrabacion;
	}

	public void setLinkGrabacion(String linkGrabacion) {
		this.linkGrabacion = linkGrabacion;
	}

	public List<Material> getMateriales() {
		return materiales;
	}

	public void setMateriales(List<Material> materiales) {
		this.materiales = materiales;
	}

	public Unidad getUnidad() {
		return unidad;
	}

	public void setUnidad(Unidad unidad) {
		this.unidad = unidad;
	}

	public List<Ejercicio> getEjercicios() {
		return ejercicios;
	}

	public void setEjercicios(List<Ejercicio> ejercicios) {
		this.ejercicios = ejercicios;
	}
	
}