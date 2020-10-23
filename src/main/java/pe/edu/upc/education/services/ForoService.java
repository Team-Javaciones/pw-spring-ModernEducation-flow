package pe.edu.upc.education.services;

import java.util.List;

import pe.edu.upc.education.models.entities.Foro;

public interface ForoService extends CrudService<Foro, Integer> {
	List<Foro> findByTema(String tema) throws Exception;
}
