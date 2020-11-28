package pe.edu.upc.education.models.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "alumno_cursos")
@IdClass(AlumnoCursoId.class )
public class AlumnoCurso {
	
	@Id	
	@ManyToOne
	@JoinColumn(name = "alumno_id")	
	private Alumno alumno;
		
	@Id	
	@ManyToOne
	@JoinColumn(name = "curso_id")
	private Curso curso;
	
	@Column(name = "bloqueado", nullable = false)
	private Boolean bloqueado;
	
	@Column(name = "valoracion", nullable = true)
	private Float valoracion;
	
	@Column(name = "comentario", length = 300, nullable = true)
	private String comentario;

	public Alumno getAlumno() {
		return alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public Boolean getBloqueado() {
		return bloqueado;
	}

	public void setBloqueado(Boolean bloqueado) {
		this.bloqueado = bloqueado;
	}

	public Float getValoracion() {
		return valoracion;
	}

	public void setValoracion(Float valoracion) {
		this.valoracion = valoracion;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}	
}
