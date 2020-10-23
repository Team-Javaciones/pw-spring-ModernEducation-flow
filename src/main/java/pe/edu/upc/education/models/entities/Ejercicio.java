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
import javax.persistence.Table;

@Entity
@Table(name = "ejercicios")
public class Ejercicio {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "nombre", length = 50, nullable = false)
	private String nombre;
	
	@Column(name = "enunciado", length = 500, nullable = false)
	private String enunciado;
	
	@OneToMany(mappedBy = "ejercicio")
	private List<Solucion> soluciones;
	
	@ManyToOne
	@JoinColumn(name = "sesion_id")
	private Sesion sesion;
	
	public Ejercicio() {
		soluciones = new ArrayList<Solucion>();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEnunciado() {
		return enunciado;
	}

	public void setEnunciado(String enunciado) {
		this.enunciado = enunciado;
	}

	public List<Solucion> getSoluciones() {
		return soluciones;
	}

	public void setSoluciones(List<Solucion> soluciones) {
		this.soluciones = soluciones;
	}

	public Sesion getSesion() {
		return sesion;
	}

	public void setSesion(Sesion sesion) {
		this.sesion = sesion;
	}
	
	
}
