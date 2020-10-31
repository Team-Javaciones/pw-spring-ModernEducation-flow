package pe.edu.upc.education.services;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.education.models.entities.Asesor;

public interface AsesorService extends CrudService<Asesor, Integer> {
	List<Asesor> findByNombreCompleto(String nombreCompleto) throws Exception;
	Optional<Asesor> findByUsername(String username) throws Exception;
	List<Asesor> findByCorreoContaining(String correo) throws Exception;
	List<Asesor> findByPasswordContaining(String password) throws Exception;

}
