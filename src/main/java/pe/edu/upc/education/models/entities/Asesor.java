package pe.edu.upc.education.models.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "asesores")
public class Asesor {
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
	private Date fechaNacimiento;
	
	@Column(name = "username", length = 50, nullable = false)
	private String username;
	
	@Column(name = "password", length = 50, nullable = false)
	private String password;
	
	@Column(name = "tocken", nullable = true)
	private Integer tocken;
	
	@Column(name = "cuenta_zoom", length = 50, nullable = false)
	private String cuentaZoom;
	
	@Column(name = "enlace_documento", length = 250, nullable = false)
	private String enlaceDocumento;
		
	@OneToMany(mappedBy = "asesor")
	private List<Curso> cursos;
	
	public Asesor() {
		cursos = new ArrayList<Curso>();
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

	public Integer getTocken() {
		return tocken;
	}

	public void setTocken(Integer tocken) {
		this.tocken = tocken;
	}

	public String getCuentaZoom() {
		return cuentaZoom;
	}

	public void setCuentaZoom(String cuentaZoom) {
		this.cuentaZoom = cuentaZoom;
	}
	
	public String getEnlaceDocumento() {
		return enlaceDocumento;
	}

	public void setEnlaceDocumento(String enlaceDocumento) {
		this.enlaceDocumento = enlaceDocumento;
	}

	public List<Curso> getCursos() {
		return cursos;
	}

	public void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
	}
	
}