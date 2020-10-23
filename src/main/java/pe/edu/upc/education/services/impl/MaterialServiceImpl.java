package pe.edu.upc.education.services.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.education.models.entities.Material;
import pe.edu.upc.education.models.repositories.MaterialRepository;
import pe.edu.upc.education.services.MaterialService;

@Service
public class MaterialServiceImpl implements MaterialService, Serializable {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private MaterialRepository materialRepository;
	
	@Transactional
	@Override
	public Material save(Material entity) throws Exception {
		return materialRepository.save(entity);
	}

	@Transactional
	@Override
	public Material update(Material entity) throws Exception {
		return materialRepository.save(entity);
	}

	@Transactional
	@Override
	public void deleteById(Integer id) throws Exception {
		materialRepository.deleteById(id);
	}

	@Override
	public Optional<Material> findById(Integer id) throws Exception {
		return materialRepository.findById(id);
	}

	@Override
	public List<Material> findAll() throws Exception {
		return materialRepository.findAll();
	}

	@Override
	public List<Material> findByNombre(String nombre) throws Exception {
		return materialRepository.findByNombreContaining(nombre);
	}

}
