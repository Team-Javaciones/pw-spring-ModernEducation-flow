package pe.edu.upc.education.services;

import java.util.List;

import pe.edu.upc.education.models.entities.Unidad;

public interface UnidadService extends CrudService<Unidad, Integer> {
	List<Unidad> findByNombre(String nombre) throws Exception; 
}
