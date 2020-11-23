package pe.edu.upc.education.init;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import pe.edu.upc.education.models.entities.Alumno;
import pe.edu.upc.education.models.entities.Asesor;
import pe.edu.upc.education.models.repositories.AlumnoRepository;
import pe.edu.upc.education.models.repositories.AsesorRepository;
import pe.edu.upc.education.models.repositories.AuthorityAlumnoRepository;
import pe.edu.upc.education.models.repositories.AuthorityAsesorRepository;

@Service
public class AddUserDB implements CommandLineRunner{

	@Autowired
	private AlumnoRepository alumnoRepository;
	@Autowired
	private AuthorityAlumnoRepository authorityAlumnoRepository;
	@Autowired
	private AsesorRepository asesorRepository;
	@Autowired
	private AuthorityAsesorRepository authorityAsesorRepository;
	
	@Override
	public void run(String... args) throws Exception {
		/*Alumno alumno1 = new Alumno();
		alumno1.setNombreCompleto("alumno1");
		alumno1.setCorreo("alumno1@domain.com");
		alumno1.setEntidadEducativa("escuela");
		alumno1.setFechaNacimiento(new Date());
		alumno1.setTelefono("555-5555");
		alumno1.setUsername("alumno1");
		alumno1.setPassword(new BCryptPasswordEncoder().encode("alumno1"));
		alumno1.setEnable(true);
		alumno1.addAuthority("ROLE_ALUMNO");
		alumnoRepository.save(alumno1);
		
		Alumno alumno2 = new Alumno();
		alumno2.setNombreCompleto("alumno2");
		alumno2.setCorreo("alumno2@domain.com");
		alumno2.setEntidadEducativa("escuela");
		alumno2.setFechaNacimiento(new Date());
		alumno2.setTelefono("555-5555");
		alumno2.setUsername("alumno2");
		alumno2.setPassword(new BCryptPasswordEncoder().encode("alumno2"));
		alumno2.setEnable(true);
		alumno2.addAuthority("ROLE_ALUMNO");
		alumnoRepository.save(alumno2);
		
		Asesor asesor1 = new Asesor();
		asesor1.setNombreCompleto("asesor1");
		asesor1.setCorreo("asesor1@domain.com");
		asesor1.setCuentaZoom("asesor1@domain.com");
		asesor1.setFechaNacimiento(new Date());
		asesor1.setTelefono("555-5555");
		asesor1.setUsername("asesor1");
		asesor1.setValoracion(5.0f);
		asesor1.setEnlaceDocumento("https://google.drive");
		asesor1.setPassword(new BCryptPasswordEncoder().encode("asesor1"));
		asesor1.setEnable(true);
		asesor1.addAuthority("ROLE_ASESOR");
		asesorRepository.save(asesor1);*/
	}
	
}
