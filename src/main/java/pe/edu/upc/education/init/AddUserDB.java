package pe.edu.upc.education.init;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import pe.edu.upc.education.models.entities.Alumno;
import pe.edu.upc.education.models.entities.Asesor;
import pe.edu.upc.education.models.entities.Usuario;
import pe.edu.upc.education.models.repositories.AlumnoRepository;
import pe.edu.upc.education.models.repositories.AsesorRepository;
import pe.edu.upc.education.models.repositories.AuthorityRepository;
import pe.edu.upc.education.models.repositories.UsuarioRepository;

@Service 
public class AddUserDB implements CommandLineRunner {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	private AuthorityRepository authorityRepository;
	
	@Autowired
	private AlumnoRepository alumnoRepository;

	@Autowired
	private AsesorRepository asesorRepository;
	
	public void run(String... args) throws Exception {
		/*
		Usuario u_alumno1 = new Usuario();
		u_alumno1.setUsername("alumno1");
		u_alumno1.setPassword( new BCryptPasswordEncoder().encode("alumno1") );
		u_alumno1.setTipo("ALUMNO");
		u_alumno1.setEnable(true);
		u_alumno1.addAuthority("ROLE_ALUMNO");
		usuarioRepository.save(u_alumno1);
		
		Alumno a_alumno1 = new Alumno();
		a_alumno1.setCorreo("alumno1@example.com");
		a_alumno1.setFechaNacimiento(new Date());
		a_alumno1.setNombreCompleto("alumno1");
		a_alumno1.setTelefono("1111111");
		a_alumno1.setUsername("alumno1");
		a_alumno1.setEntidadEducativa("alumno1");
		alumnoRepository.save(a_alumno1);
		
		Usuario u_alumno2 = new Usuario();
		u_alumno2.setUsername("alumno2");
		u_alumno2.setPassword( new BCryptPasswordEncoder().encode("alumno2") );
		u_alumno2.setTipo("ALUMNO");
		u_alumno2.setEnable(true);
		u_alumno2.addAuthority("ROLE_ALUMNO");
		usuarioRepository.save(u_alumno2);
		
		Alumno a_alumno2 = new Alumno();
		a_alumno2.setCorreo("alumno2@example.com");
		a_alumno2.setFechaNacimiento(new Date());
		a_alumno2.setNombreCompleto("alumno2");
		a_alumno2.setTelefono("2222222");
		a_alumno2.setUsername("alumno2");
		a_alumno2.setEntidadEducativa("alumno2");
		alumnoRepository.save(a_alumno2);
		
		Usuario u_asesor1 = new Usuario();
		u_asesor1.setUsername("asesor1");
		u_asesor1.setPassword( new BCryptPasswordEncoder().encode("asesor1") );
		u_asesor1.setTipo("ASESOR");
		u_asesor1.setEnable(true);
		u_asesor1.addAuthority("ROLE_ASESOR");
		usuarioRepository.save(u_asesor1);
		
		Asesor a_asesor1 = new Asesor();
		a_asesor1.setCorreo("asesor1@example.com");
		a_asesor1.setFechaNacimiento(new Date());
		a_asesor1.setNombreCompleto("asesor1");
		a_asesor1.setTelefono("1111111");
		a_asesor1.setUsername("asesor1");
		a_asesor1.setCuentaZoom("asesor1@example.com");
		a_asesor1.setEnlaceDocumento("drive.google.com");
		asesorRepository.save(a_asesor1);
		
		
		System.out.println("USUARIOS CREADOS");*/
	}

}