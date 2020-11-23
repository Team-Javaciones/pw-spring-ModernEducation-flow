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
	@DateTimeFormat(iso = ISO.DATE)
	private Date fechaNacimiento;
	
	@Column(name = "username", length = 50, nullable = false)
	private String username;
	
	@Column(name = "password", length = 50, nullable = false)
	private String password;
	
	private Boolean enable;
	
	@OneToMany(mappedBy = "asesor", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<AuthorityAsesor> authorities;
	
	@Column(name = "valoracion", nullable = true)
	private Float valoracion;
	
	@Column(name = "cuenta_zoom", length = 50, nullable = false)
	private String cuentaZoom;
	
	@Column(name = "enlace_documento", length = 250, nullable = false)
	private String enlaceDocumento;
		
	@OneToMany(mappedBy = "asesor")
	private List<Curso> cursos;
	
	@OneToMany(mappedBy = "asesor")
	private List<AlumnoAsesor> alumnoAsesores;
	
	public Asesor() {
		
		this.enable = true;
		this.authorities = new ArrayList<>();
		
		cursos = new ArrayList<Curso>();
		alumnoAsesores = new ArrayList<AlumnoAsesor>();
	}
	public Asesor(String username, String password) {
		
		this.username = username;
		this.password = password;
		this.enable = true;
		this.authorities = new ArrayList<>();
		
		cursos = new ArrayList<Curso>();
		alumnoAsesores = new ArrayList<AlumnoAsesor>();
	}
	public Boolean getEnable() {
		return enable;
	}
	public void setEnable(Boolean enable) {
		this.enable = enable;
	}
	public List<AuthorityAsesor> getAuthorities() {
		return authorities;
	}
	public void setAuthorities(List<AuthorityAsesor> authorities) {
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

	public void updateValoracion() {
		Float val = 0F;
		Integer cont = 0;
		
		for (AlumnoAsesor alumnoAsesor : alumnoAsesores) {	
			if(alumnoAsesor.getValoracion() != null) {
				val += alumnoAsesor.getValoracion();
				cont++;
			}
		}
		if(cont != 0)
			setValoracion(Math.round(val/cont * 10F) / 10.0F);			
		else 
			setValoracion(null);		
	}
	
	public Float getValoracion() {
		updateValoracion();
		return valoracion;
	}

	public void setValoracion(Float valoracion) {
		this.valoracion = valoracion;
	}

	public List<AlumnoAsesor> getAlumnoAsesor() {
		return alumnoAsesores;
	}

	public void setAlumnoAsesor(List<AlumnoAsesor> alumnoAsesor) {
		this.alumnoAsesores = alumnoAsesor;
	}
	
}