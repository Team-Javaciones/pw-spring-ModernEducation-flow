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
@Table(name = "foros")
public class Foro {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "tema", length = 50, nullable = false)
	private String tema;
		
	@OneToMany(mappedBy = "foro")
	private List<Entrada> entradas;
	
	@OneToOne
	@JoinColumn(name = "sesion_id")
	private Sesion sesion;	
	
	@ManyToOne
	@JoinColumn(name = "asesor_id")
	private Asesor asesor;		
	
	
	public Foro() {
		entradas = new ArrayList<Entrada>();
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


	public List<Entrada> getEntradas() {
		return entradas;
	}


	public void setEntradas(List<Entrada> entradas) {
		this.entradas = entradas;
	}


	public Sesion getSesion() {
		return sesion;
	}


	public void setSesion(Sesion sesion) {
		this.sesion = sesion;
	}


	public Asesor getAsesor() {
		return asesor;
	}


	public void setAsesor(Asesor asesor) {
		this.asesor = asesor;
	}
	
	
}