package pe.edu.upc.education.models.entities;

import java.io.Serializable;
import java.util.Objects;


public class AlumnoCursoId implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer alumno;
	private Integer curso;
	
	public AlumnoCursoId() {		
	}
	
	public AlumnoCursoId(Integer alumno, Integer curso) {
		super();
		this.alumno = alumno;
		this.curso = curso;
	}
	
	public Integer getAlumno() {
		return alumno;
	}	
	
	public void setAlumno(Integer alumno) {
		this.alumno = alumno;
	}
	
	public Integer getCurso() {
		return curso;
	}
	
	public void setCurso(Integer curso) {
		this.curso = curso;
	}
	
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return Objects.hash(alumno, curso);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) 
			return true;
        if (obj == null || getClass() != obj.getClass()) 
        	return false;
        AlumnoCursoId alumnoCursoId = (AlumnoCursoId) obj;
        if (this.alumno != alumnoCursoId.alumno) 
        	return false;
        return this.curso == alumnoCursoId.curso;
	}

}