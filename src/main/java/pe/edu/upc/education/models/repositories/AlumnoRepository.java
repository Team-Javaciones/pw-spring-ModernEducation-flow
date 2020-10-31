package pe.edu.upc.education.models.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.education.models.entities.Alumno;

@Repository
public interface AlumnoRepository extends JpaRepository<Alumno, Integer>{
	List<Alumno> findByEntidadEducativaContaining(String entidadEducativa) throws Exception; 
	List<Alumno> findByNombreCompletoContaining(String nombreCompleto) throws Exception;
	Optional<Alumno> findByUsername(String username) throws Exception;
	List<Alumno> findByCorreoContaining(String correo) throws Exception;
	List<Alumno> findByPasswordContaining(String password) throws Exception;
}