package pe.edu.upc.education.models.entities;

import java.util.ArrayList;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "cursos")
public class Curso {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "nombre", length = 50, nullable = false)
	private String nombre;
	
	@Column(name = "descripcion", length = 250, nullable = false)
	private String descripcion;
	
	@Column(name = "popularidad", nullable = false)
	private Float popularidad;
	
	@ManyToOne
	@JoinColumn(name = "asesor_id")
	private Asesor asesor;
	
	@Column(name = "precio", nullable = false)
	private Float precio;
	
	@Column(name = "horas", nullable = false)
	private Integer horas;
		
	@Column(name = "capacidad", nullable = false)
	private Integer capacidad;
	
	@OneToMany(mappedBy = "curso")	
	private List<AlumnoCurso> alumnoCursos;	
	
	@OneToMany(mappedBy = "curso")
	private List<Unidad> unidades;
	
	@Column(name = "fecha_inicio", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date fechaInicio;
	
	@Column(name = "fecha_fin", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date fechaFin;
	
	@ManyToOne
	@JoinColumn(name = "categoria_id")
	private Categoria categoria;	
	
	
	public Curso() {
		alumnoCursos = new ArrayList<AlumnoCurso>();
		unidades = new ArrayList<Unidad>();
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


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public Float getPopularidad() {
		return popularidad;
	}


	public void setPopularidad(Float popularidad) {
		this.popularidad = popularidad;
	}


	public Asesor getAsesor() {
		return asesor;
	}


	public void setAsesor(Asesor asesor) {
		this.asesor = asesor;
	}


	public Float getPrecio() {
		return precio;
	}


	public void setPrecio(Float precio) {
		this.precio = precio;
	}


	public Integer getHoras() {
		return horas;
	}


	public void setHoras(Integer horas) {
		this.horas = horas;
	}

	public Integer getCapacidad() {
		return capacidad;
	}


	public void setCapacidad(Integer capacidad) {
		this.capacidad = capacidad;
	}


	public List<AlumnoCurso> getAlumnoCursos() {
		return alumnoCursos;
	}


	public void setAlumnoCursos(List<AlumnoCurso> alumnoCursos) {
		this.alumnoCursos = alumnoCursos;
	}


	public List<Unidad> getUnidades() {
		return unidades;
	}


	public void setUnidades(List<Unidad> unidades) {
		this.unidades = unidades;
	}


	public Date getFechaInicio() {
		return fechaInicio;
	}


	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}


	public Date getFechaFin() {
		return fechaFin;
	}


	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}


	public Categoria getCategoria() {
		return categoria;
	}


	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	
}