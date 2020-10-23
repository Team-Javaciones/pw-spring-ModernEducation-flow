package pe.edu.upc.education.services;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.education.models.entities.Alumno;

public interface AlumnoService extends CrudService<Alumno, Integer> {
	List<Alumno> findByEntidadEducativa(String entidadEducativa) throws Exception; 
	List<Alumno> findByNombreCompleto(String nombreCompleto) throws Exception;
	Optional<Alumno> findByUsername(String username) throws Exception;
}
