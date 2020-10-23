package pe.edu.upc.education.services;

import java.util.List;

import pe.edu.upc.education.models.entities.Sesion;

public interface SesionService extends CrudService<Sesion, Integer> {
	List<Sesion> findByTema(String tema) throws Exception;
}
