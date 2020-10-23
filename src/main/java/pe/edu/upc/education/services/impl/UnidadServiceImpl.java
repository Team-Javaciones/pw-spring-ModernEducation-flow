package pe.edu.upc.education.services.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.education.models.entities.Unidad;
import pe.edu.upc.education.models.repositories.UnidadRepository;
import pe.edu.upc.education.services.UnidadService;

@Service
public class UnidadServiceImpl implements UnidadService, Serializable {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private UnidadRepository unidadRepository;
	
	@Transactional
	@Override
	public Unidad save(Unidad entity) throws Exception {
		return unidadRepository.save(entity);
	}

	@Transactional
	@Override
	public Unidad update(Unidad entity) throws Exception {
		return unidadRepository.save(entity);
	}

	@Transactional
	@Override
	public void deleteById(Integer id) throws Exception {
		unidadRepository.deleteById(id);
	}
	@Transactional(readOnly = true)
	@Override
	public Optional<Unidad> findById(Integer id) throws Exception {
		return unidadRepository.findById(id);
	}
	@Transactional(readOnly = true)
	@Override
	public List<Unidad> findAll() throws Exception {
		return unidadRepository.findAll();
	}
	@Transactional(readOnly = true)
	@Override
	public List<Unidad> findByNombre(String nombre) throws Exception {
		return unidadRepository.findByNombreContaining(nombre);
	}

}
