package pe.edu.upc.education.services;

import java.util.List;

import pe.edu.upc.education.models.entities.Material;

public interface MaterialService extends CrudService<Material, Integer> {
	List<Material> findByNombre(String nombre) throws Exception; 
}
