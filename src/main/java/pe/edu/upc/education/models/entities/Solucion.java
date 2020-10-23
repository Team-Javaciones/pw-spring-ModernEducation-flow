package pe.edu.upc.education.models.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "soluciones")
public class Solucion {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "comentario", length = 150, nullable = true)
	private String comentario;
	
	@Column(name = "codigo", length = 5000, nullable = false)
	private String codigo;
	
	@ManyToOne
	@JoinColumn(name = "alumno_id")
	private Alumno alumno;
	
	@Column(name = "fecha", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date fecha;
	
	@ManyToOne
	@JoinColumn(name = "ejercicio_id")
	private Ejercicio ejercicio;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Alumno getAlumno() {
		return alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Ejercicio getEjercicio() {
		return ejercicio;
	}

	public void setEjercicio(Ejercicio ejercicio) {
		this.ejercicio = ejercicio;
	}
	
	
}