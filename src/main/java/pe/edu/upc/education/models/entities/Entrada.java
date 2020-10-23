package pe.edu.upc.education.models.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "entradas")
public class Entrada {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;	
	
	@Column(name = "texto", length = 500, nullable = false)
	private String texto;
	
	@ManyToOne
	@JoinColumn(name = "alumno_id")
	private Alumno alumno;
	
	@Column(name = "respuesta", length = 500, nullable = false)
	private String respuesta;
	
	@ManyToOne
	@JoinColumn(name = "foro_id")
	private Foro foro;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}
	
	public String getRespuesta() {
		return respuesta;
	}

	public void setRespuesta(String respuesta) {
		this.respuesta = respuesta;
	}

	public Foro getForo() {
		return foro;
	}

	public void setForo(Foro foro) {
		this.foro = foro;
	}

	public Alumno getAlumno() {
		return alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}
		
}
