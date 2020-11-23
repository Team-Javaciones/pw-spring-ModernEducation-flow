package pe.edu.upc.education.models.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
@Table(name = "alumnos")
public class Alumno { //Edit para test
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "nombre_completo", length = 50, nullable = false)
	private String nombreCompleto;
	
	@Column(name = "telefono", length = 15, nullable = false)
	private String telefono;
	
	@Column(name = "correo", length = 50, nullable = false)
	private String correo;
	
	@Column(name = "fecha_nacimiento", nullable = false)
	@Temporal(TemporalType.DATE) 
	@DateTimeFormat(iso = ISO.DATE)
	private Date fechaNacimiento;
	
	@Column(name = "username", length = 50, nullable = false)
	private String username;
	
	@Column(name = "password", length = 60, nullable = false)
	private String password;
	
	private Boolean enable;
	
	//ATENCION AQUI
	@OneToMany(mappedBy = "alumno", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<AuthorityAlumno> authorities;
	
	@Column(name = "entidad_educativa", length = 50, nullable = false)
	private String entidadEducativa;
		
	@OneToMany(mappedBy = "alumno")
	private List<AlumnoCurso> alumnoCursos;
	
	@OneToMany(mappedBy = "alumno")
	private List<AlumnoAsesor> alumnoAsesores;
	
	@OneToMany(mappedBy = "alumno")
	private List<Solucion> soluciones;
	
	public Alumno() {		
		this.enable = true;
		this.authorities = new ArrayList<>();
		
		alumnoCursos = new ArrayList<AlumnoCurso>();
		alumnoAsesores = new ArrayList<AlumnoAsesor>();
		soluciones = new ArrayList<Solucion>();
	}
	public Alumno(String username, String password) {
		
		this.username = username;
		this.password = password;
		this.enable = true;
		this.authorities = new ArrayList<>();
		
		alumnoCursos = new ArrayList<AlumnoCurso>();
		alumnoAsesores = new ArrayList<AlumnoAsesor>();
		soluciones = new ArrayList<Solucion>();
	}
	public void addAuthority( String auth ) {
		AuthorityAlumno authority = new AuthorityAlumno();
		authority.setAuthority( auth ) ;
		authority.setAlumno( this );
		
		this.authorities.add( authority );
	}

	public Boolean getEnable() {
		return enable;
	}
	public void setEnable(Boolean enable) {
		this.enable = enable;
	}
	public List<AuthorityAlumno> getAuthorities() {
		return authorities;
	}
	public void setAuthorities(List<AuthorityAlumno> authorities) {
		this.authorities = authorities;
	}
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}	

	public String getNombreCompleto() {
		return nombreCompleto;
	}

	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	public String getEntidadEducativa() {
		return entidadEducativa;
	}

	public void setEntidadEducativa(String entidadEducativa) {
		this.entidadEducativa = entidadEducativa;
	}

	public List<AlumnoCurso> getAlumnoCursos() {
		return alumnoCursos;
	}

	public void setAlumnoCursos(List<AlumnoCurso> alumnoCursos) {
		this.alumnoCursos = alumnoCursos;
	}

	public List<Solucion> getSoluciones() {
		return soluciones;
	}

	public void setSoluciones(List<Solucion> soluciones) {
		this.soluciones = soluciones;
	}

	public List<AlumnoAsesor> getAlumnoAsesor() {
		return alumnoAsesores;
	}

	public void setAlumnoAsesor(List<AlumnoAsesor> alumnoAsesor) {
		this.alumnoAsesores = alumnoAsesor;
	}		
	
}
